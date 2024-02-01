package vop;

public class CaesarCipher extends AbstractCipher{
    protected int rotFactor;

    public CaesarCipher(int rotFactor){
        if (rotFactor < 0 || rotFactor > ALPHABETH.length){
            this.rotFactor = 0;
        } else this.rotFactor = rotFactor;
    }

    @Override
    public String encrypt(String original) {
        char[] msg = original.toCharArray();
        String result = "";

        for (int i = 0; i < msg.length; i++){
            if (findCharIndex(msg[i]) != -1){
                result += ALPHABETH[(findCharIndex(msg[i]) + rotFactor) % ALPHABETH.length];
            } else result += msg[i];

        }

        return result;
    }

    @Override
    public String decrypt(String encrypted) {
        char[] msg = encrypted.toCharArray();
        String result = "";

        for (int i = 0; i < msg.length; i++){
            if (findCharIndex(msg[i]) != -1){
                result += ALPHABETH[((findCharIndex(msg[i]) + ALPHABETH.length - rotFactor) % ALPHABETH.length)];

            } else result += msg[i];

        }

        return result;
    }
}
