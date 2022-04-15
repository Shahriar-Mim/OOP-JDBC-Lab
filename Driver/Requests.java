package Driver;

import Dao.SectionDaoImplementation;
import Dao.StudentDaoImplement;
import model.Section;
import model.Student;
import model.Temporary;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;



public class Requests  {
    String tempmail;





    Scanner sc=new Scanner(System.in);
    public String regReq() throws SQLException {


        StudentDaoImplement stDaoImplement = new StudentDaoImplement();
        Student std = new Student();
        List<Student> ls = stDaoImplement.getStudents();
        int length=ls.size();


        if(length<15) {
            System.out.println("  -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("<<>>   Please Enter your name....     <<>>");

            String name=sc.nextLine();

            std.setStd_name(name);
            System.out.println("  -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("Please Enter your ID");

            String st_id=sc.nextLine();
            System.out.println(" -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            std.setStd_id(st_id);
            std.setStd_sec("0"); // default value set to zero
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("Please Enter your email");

            String email=sc.nextLine();
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            std.setStd_email(email);
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("Please Enter your password");

            String pass=sc.nextLine();
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            std.setStd_pas(pass);
            stDaoImplement.add(std);
            return "succesful";
        }
        else{
            return "No Seat left";
        }
    }


    public String logreq(int id) throws SQLException{
        Student test = new Student();
        List<Student> ls ;

          int count=0;

        if(id==1){ // for student Login
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("Please Enter your email");

            String email=sc.nextLine();
            System.out.println("  -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");

            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("Please Enter your pass");

            String pass=sc.nextLine();
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            StudentDaoImplement studentDaoImplement=new StudentDaoImplement();
            ls=studentDaoImplement.getStudents();

            for (int i = 0; i < ls.size(); i++) {
                if (email.equals(ls.get(i).getStd_email()) && pass.equals(ls.get(i).getStd_pas()))
                    count++;
            }

            if(count>0){
                Temporary temporary=new Temporary();
                temporary.setTempmail(email);
                this.tempmail=email;
                return "succesful";
            }
            else {
                return "Wrong email or password!!!";
            }



        }

        else if(id==2){ // for faculty Login
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("Please Enter your email");
            String email=sc.nextLine();
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");

            System.out.println("Please Enter your passord");

            String pass = sc.nextLine();
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            Temporary temporary=new Temporary();
            temporary.setTempmail(email);
            System.out.println("ekhan theke success return hobe");
            return "succesful";


        }
        else {
            return "wrong id";
        }

    }



    public String bookingreq(String book,String email) throws SQLException{
        SectionDaoImplementation sectionDaoImplementation=new SectionDaoImplementation();
        List<Section> ss=sectionDaoImplementation.getSection();
        StudentDaoImplement studentDaoImplement=new StudentDaoImplement();
        List<Student> ls=studentDaoImplement.getStudents();
        studentDaoImplement.update(email,book);
        if(book.equals("1")){
            sectionDaoImplementation.update(ss.get(0));
        }
        else {
            sectionDaoImplementation.update(ss.get(1));
        }
        return "booking done";
    }



    public void sectionStatus() throws SQLException{
        System.out.println("Logged in...");
        SectionDaoImplementation sectionDaoImplementation = new SectionDaoImplementation();
        List<Section> ls = sectionDaoImplementation.getSection();
        for (int i = 0; i < 2; i++) {
            System.out.print("Section:0"+ls.get(i).getSection_no()+"\t\t");
           // System.out.print(ls.get(i).getSection_no() + "      Timing: ");
            System.out.print(ls.get(i).getTiming()+"\t\t");
            System.out.println(ls.get(i).getSeat_remaining()+" seats remaining");


        }
        System.out.println("To abort type X");
        String key = sc.nextLine();
        if (key.equalsIgnoreCase("X")){
            return;
        }
        System.out.println("Type 1 for section 1 and type 2 for section 2");
        String sect=sc.next();

            System.out.println(bookingreq(sect,this.tempmail));

    }

}
