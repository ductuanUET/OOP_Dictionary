import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> database;

    /**
     * construction no param
     */
    Dictionary() {
        database = new ArrayList<Word>(0);
    }

    public int getLengthDictionary() {
        return database.size();
    }

    public Word getWordIndex(int index) {
        return database.get(index);
    }
    public void getInfoWord(int index) {
        database.get(index).showWord();
    }

    public void addWordToDictionary(Word word) {
        boolean check;
        if (indexOf(word) == -1) {
            check = false;
        } else {
            check = true;
        }
        if (!check) {
            this.database.add(word);
            System.out.println("Dictonary add " + word.getWordTarget());
        } else {
            System.out.println("Dictionary have word " + word.getWordTarget());
        }
    }

    public boolean containsWordInDictionary(Word word) {
        if (indexOf(word) == -1)    return false;
        return true;
    }

    public void printWordIndex(int index) {
        Word word = this.database.get(index);
        word.showWord();
    }

    public void removeWordInDictionary(Word word) {
        //int index = this.words.indexOf(word);
        int index = indexOf(word);
        this.database.remove(index);
    }

    public void printDictionary() {
        System.out.println("INDEX       ENGLISH             VIETNAMESE");
        for (int i = 0; i < this.database.size(); i++) {
            System.out.printf("%-5d %s \n", i, this.database.get(i));
        }
    }

    public void sortDictionary() {
        for(int i = 0; i < database.size() - 1; i++) {
            for(int j = i +1; j < database.size(); j++) {
                if (database.get(i).compareTo(database.get(j)) > 0) {
                    database.get(i).swap(database.get(j));
                }
            }
        }
    }

    public void insertionSortDictionary() {
        for (int i = 0; i < database.size(); i++) {
            boolean isSwap = false;
            for (int j = database.size() - 1; j > 1; j--) {
                if (database.get(j).compareTo(database.get(j-1)) < 0) {
                    database.get(j).swap(database.get(j-1));
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }

    /**
     * use the binaryFinding and it is reused for many method
     * @param word
     * @return indexWord
     */
    public int indexOf(Word word) {
        int begin = 0;
        int end = database.size()-1;
        int mid = (begin + end)/2;
        while (begin <= end) {
            if (word.equals(database.get(mid)))    return mid;
            if (word.compareTo(database.get(mid)) < 0) {
                end = mid -1;
            }
            if (word.compareTo(database.get(mid)) > 0) {
                begin = mid + 1;
            }
            mid = (begin + end)/2;
        }
        return -1;
    }

    //Them ham tim kiem.
    public Word dictionaryLookup(String a) {
        for (Word e : database) {
            if (e.getWordTarget().equals(a)) {
                return e;
            }
        }
        return null;
    }
}