package vop;

public class AtbashCipher extends AbstractCipher{

    @Override
    public String encrypt(String original) {
        char[] msgDecrypt = original.toCharArray();
        String result = "";

        for (char i:msgDecrypt) {
            if (findCharIndex(i) != -1){
                result += ALPHABETH[((ALPHABETH.length - 1) - findCharIndex(i)) % ALPHABETH.length];
            } else result += i;
        }
        return result;
    }

    @Override
    public String decrypt(String encrypted) {
        return encrypt(encrypted);
    }
}
