package vop;

public abstract class AbstractCipher implements CipherInterface {
    protected int findCharIndex(char ch){
        int index = -1;
        for (int i = 0; i < ALPHABETH.length; i++) {
            if (ALPHABETH[i] == ch){
                index = i;
            }
        }
        return index;
    }
}
