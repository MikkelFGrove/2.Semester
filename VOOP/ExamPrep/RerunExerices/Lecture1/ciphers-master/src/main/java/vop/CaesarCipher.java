package vop;

public class CaesarCipher extends AbstractCipher{
    int rotFactor;

    public CaesarCipher(int rotFactor){
        if (rotFactor < 0 || rotFactor > ALPHABETH.length){
            this.rotFactor = rotFactor;
            System.out.println("Rot Factor is negative or smaller than the length of the alphabet ***rotFactor set to 0***");
        } else {
            this.rotFactor = rotFactor;
        }
    }

    @Override
    public String encrypt(String original) {
        StringBuilder sb = new StringBuilder();
        int index;
        for(char c : original.toCharArray()){
            index = findCharIndex(c);
            if(index > -1){
                index = (index + rotFactor) % ALPHABETH.length;
                sb.append(ALPHABETH[ALPHABETH.length - 1 - index]);
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Override
    public String decrypt(String encrypted) {
        return encrypt(encrypted);
    }
}
