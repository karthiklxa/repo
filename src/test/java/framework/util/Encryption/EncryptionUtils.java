package framework.util.Encryption;

/**
 * Created by karthik.m on 9/12/2018.
 */
/**
 * COPYRIGHT: Comviva Technologies Pvt. Ltd.
 * This software is the sole property of Comviva and is protected
 * by copyright law and international treaty provisions. Unauthorized
 * reproduction or redistribution of this program, or any portion of
 * it may result in severe civil and criminal penalties and will be
 * prosecuted to the maximum extent possible under the law.
 * Comviva reserves all rights not expressly granted. You may not
 * reverse engineer, decompile, or disassemble the software, except
 * and only to the extent that such activity is expressly permitted
 * by applicable law notwithstanding this limitation.
 * THIS SOFTWARE IS PROVIDED TO YOU "AS IS" WITHOUT WARRANTY OF ANY
 * KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 * PARTICULAR PURPOSE. YOU ASSUME THE ENTIRE RISK AS TO THE ACCURACY
 * AND THE USE OF THIS SOFTWARE. Comviva SHALL NOT BE LIABLE FOR
 * ANY DAMAGES WHATSOEVER ARISING OUT OF THE USE OF OR INABILITY TO
 * USE THIS SOFTWARE, EVEN IF Comviva HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 **/

//        import com.btsl.common.BTSLActionSupport;
//        import com.btsl.common.util.Constants;
//        import com.comviva.merchant.beans.AESResponse;
//        import com.comviva.mpos.constants.ValidationConstant;
//        import com.google.gson.Gson;

        import java.security.Key;
        import java.util.Arrays;

        import java.io.InputStream;
        import java.security.PublicKey;
        import java.security.SecureRandom;
        import java.security.cert.CertificateException;
        import java.security.cert.CertificateFactory;
        import java.security.cert.X509Certificate;
        import java.util.HashMap;
        import java.util.Map;

        import javax.crypto.Cipher;
        import javax.crypto.KeyGenerator;
        import javax.crypto.SecretKey;
        import javax.crypto.spec.IvParameterSpec;
        import javax.crypto.spec.SecretKeySpec;
        import javax.xml.bind.DatatypeConverter;

        import org.apache.commons.codec.binary.Base64;
        import org.apache.commons.logging.Log;
        import org.apache.commons.logging.LogFactory;




public class EncryptionUtils  {

    /**
     *
     */
//    private static final long serialVersionUID = 6614358031697172453L;
    private static final Log LOG = LogFactory.getLog(EncryptionUtils.class);
//    private static final String split = "\n";
//
//    private EncryptionUtils() {
//        // Empty Constructor
//    }
//
//    private static Key key = new Key() {
//        /**
//         *
//         */
//        private static final long serialVersionUID = 8364691780204860582L;
//
//        @Override
//        public String getAlgorithm() {
//            return "AES";
//        }
//
//        @Override
//        public String getFormat() {
//            return null;
//        }
//
//        @Override
//        public byte[] getEncoded() {
//            return ValidationConstant.randomString;
//        }
//    };
//
//    /**
//     * This method provides the decrypted string
//     * @param input
//     * 			AES encrytped string if deployment enabled with Encryption
//     * @return
//     * 			Decrypted String else the input string on error
//     */
//    public static String getAESDecryptedString(String input){
//        String output = input;
//        try{
//            output = aesDecryption(input, "businessPan");
//        }catch(Exception e){
//            output = input;
//            LOG.error("Error decrypting string",e);
//        }
//        return output;
//    }
//
//    /**
//     * Decrypts text encrypted by aesEncryption function
//     *
//     * @param inputString
//     * @param alias
//     * @return Decrypted plain text
//     * @throws Exception
//     */
//    public static String aesDecryption(String inputString, String alias) throws Exception {
//        byte[] decryptedTextBytes;
//        try {
//            String[] inputMessageAndIV = inputString.split(split);
//
//            if (inputMessageAndIV.length != 2) {
//                throw new Exception("Invalid AES encrypted string.");
//            }
//            byte[] ivBytes = DatatypeConverter.parseBase64Binary(inputMessageAndIV[1]);
//            byte[] encryptedTextBytes = DatatypeConverter.parseBase64Binary(inputMessageAndIV[0]);
//            SecretKeySpec secretSpec = new SecretKeySpec(key.getEncoded(), "AES");
//            Cipher cipher;
//            if (Arrays.equals(ivBytes, " ".getBytes())) {
//                cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//                cipher.init(Cipher.DECRYPT_MODE, secretSpec);
//            } else {
//                cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//                cipher.init(Cipher.DECRYPT_MODE, secretSpec, new IvParameterSpec(ivBytes));
//            }
//            decryptedTextBytes = cipher.doFinal(encryptedTextBytes);
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//        return new String(decryptedTextBytes);
//    }
//
//    /**
//     * This method returns the encrytion flag as set on deployment
//     * @return
//     * 		encrypt Required flag
//     */
//    public static boolean isEncryptionEnabled(){
//        boolean isEncryption = false;
//        if ("Y".equalsIgnoreCase(Constants.getProperty("IS_ENCRYPTION"))) {
//            isEncryption = true;
//        }
//        return isEncryption;
//    }
//
//
    public static PublicKey getPublicKeyFromCert(){
        InputStream ins = EncryptionUtils.class.getResourceAsStream("/mconfigfiles/otacert.pem");
        CertificateFactory f;
        PublicKey pk=null;
        try {
            f = CertificateFactory.getInstance("X.509");
            X509Certificate certificate = (X509Certificate)f.generateCertificate(ins);
            pk = certificate.getPublicKey();
        } catch (CertificateException e) {
            LOG.error("Error reading public key:", e);
        }
        return pk;
    }


    private static PublicKey pub = null;

    private static void encryptWithPublic(byte[] symKey, Map<String,Object> reqMap) {
        byte[] cipherText = null;
        try {
            final Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            // encrypt the plain text using the public key
            if(pub == null){
                pub = getPublicKeyFromCert();
            }
            cipher.init(Cipher.ENCRYPT_MODE, pub);
            cipherText = cipher.doFinal(symKey);
            reqMap.put("payloadToken",convertToString(cipherText));
        } catch (Exception e) {
            LOG.error("Exception occurred", e);
        }
    }

    public static Map<String,Object> packetEncryption(String text){
        try{
            Map<String,Object> requestJson = new HashMap<>();
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();

            final int AES_KEYLENGTH = 128;
            byte[] iv = new byte[AES_KEYLENGTH / 8];
            SecureRandom prng = new SecureRandom();
            prng.nextBytes(iv);

            Cipher aesCipherForEncryption = Cipher.getInstance("AES/CBC/PKCS5PADDING");

            aesCipherForEncryption.init(Cipher.ENCRYPT_MODE, secretKey,
                    new IvParameterSpec(iv));

            byte[] byteDataToEncrypt = text.getBytes();
            byte[] byteCipherText = aesCipherForEncryption
                    .doFinal(byteDataToEncrypt);

            String strCipherText = convertToString(byteCipherText);
            requestJson.put("payloadVariable",convertToString(iv) );
            requestJson.put("payloadText",strCipherText);
            requestJson.put("decryptedKey", secretKey.getEncoded());
            encryptWithPublic(secretKey.getEncoded(),requestJson);
            return requestJson;
        } catch (Exception e) {
            LOG.error("Error encrypting request packet:",e);
        }
        return null;
    }

    private static String convertToString(byte[] buffer){
        return new String(new Base64().encode(buffer));
    }

    public static String packetDecryption(String encryptedText, byte[] bKey,String iv) {
        try {
            SecretKey key2 = new SecretKeySpec(bKey, 0, bKey.length, "AES");
            Cipher cipher;
            cipher= Cipher.getInstance("AES/CBC/PKCS5PADDING");
            byte[] ivBytes = new Base64().decode(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, key2, new IvParameterSpec(ivBytes));
            byte[] encryptedTextBytes = new Base64().decode(encryptedText.getBytes());
            byte[] decryptedTextBytes ;

            decryptedTextBytes= cipher.doFinal(encryptedTextBytes);
            return new String (decryptedTextBytes);
        } catch (Exception ex) {
            LOG.error("Error in decrypting data: ", ex);
            return null;
        }

    }
}
