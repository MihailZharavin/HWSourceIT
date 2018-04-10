package HW7;

public class Zachetka {
    private String faculty;
    private int id;
    private String name;
    private Information [] exams;

    public Zachetka(int id, String faculty, String name) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
    }

    private class Information {
        private String subject;
        private int evaluation;
        private boolean pass;


        public Information(String subject){
            this.subject=subject;
            pass = false;
        }
        public int getPassedEvaluation(){
            final int PASSED_EVALUATION = 3;
            return 3;
        }

        public void passExam(){
            pass = true;
        }

        public void setEvaluation(int evaluation) {
            this.evaluation = evaluation;
        }
        public int getEvaluation(){
            return evaluation;
        }
        public String getFaculty() {
            return faculty;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
        public boolean isPass(){
            return pass;
        }
    }


    public void setExams(String [] subject,int[] evalution) {
        exams = new Information[subject.length];
        for(int i=0;i<subject.length;i++){
            exams[i]= new Information(subject[i]);
            exams[i].setEvaluation(evalution[i]);
            if(exams[i].getEvaluation()>=exams[i].getPassedEvaluation())
                exams[i].passExam();
        }
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder(100);
        s.append("ID - "+id+"\n");
        s.append("Name - "+ name+"\n");
        s.append("Faculty - "+faculty+"\n");
        for(int i=0;i<exams.length;i++){
            if(exams[i].isPass()){
                s.append(" Предмет - "+exams[i].subject+" сдал.");
            }
            else s.append(" Предмет - "+exams[i].subject+" не сдал.");
        }
        return s.toString();
    }
}
