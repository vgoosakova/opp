package Lab5;
class Sentence {
    private SentenceMember[] sentenceMembers;

    public Sentence(String s) {
        String[] split = s.split("(?=[,.!?])|\\s");
        sentenceMembers = new SentenceMember[split.length];

        for (int i = 0; i < split.length; i++) {
            String punctuationSymbols = ",.!?;:";
            if (punctuationSymbols.contains(split[i])) {
                sentenceMembers[i] = new PunctuationMark(split[i]);
            } else {
                sentenceMembers[i] = new Word(split[i]);
            }
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sentenceMembers.length; i++) {
            result.append(sentenceMembers[i] instanceof Word && i != 0 ?
                    " " : "").append(sentenceMembers[i].toString());
        }
        return result.toString();
    }

    public Word[] toWords() {
        Word[] words = new Word[this.sentenceMembers.length];
        int i = 0;

        for (SentenceMember member : this.sentenceMembers) {
            if (member instanceof Word) {
                words[i] = (Word) member;
                ++i;
            }
        }
        return words;
    }

    public int getLength() { return this.sentenceMembers.length; }
}
