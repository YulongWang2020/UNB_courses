package assn1.yw;

public class TranscriptDriver {
    public static void main(String[] args) {
        Transcript temp = new Transcript(8510804);
        temp.addGrade("CS1003 4CH B");
        temp.addGrade("CS2033 4CH A");
        temp.addGrade("ECE2213 4CH 3.3");
        temp.addGrade("ECON1001 3CH 2.0");
        temp.addGrade("CS2033 4CH B");
        temp.printTranscript();
        temp.removeByNameLetterGrade("CS2033","B");
        temp.printTranscript();
        temp.addGrade("CS2033 4CH B");
        temp.removeByName("CS2033");
        temp.printTranscript();
        Transcript newTemp = new Transcript(8510805);
        newTemp.printTranscript();
    }
}
