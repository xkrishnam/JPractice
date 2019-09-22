package ccuisse;

import java.io.*;

public class ExternalizationTest implements Externalizable {

    private String fname;
    private String lname;
    private int age;

    public ExternalizationTest() {
    }

    public ExternalizationTest(String fname, String lname, int age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(lname);
        objectOutput.writeObject(fname);
        objectOutput.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        fname=(String) objectInput.readObject();
        lname=(String) objectInput.readObject();
        age=objectInput.readInt();
    }

    @Override
    public String toString() {
        return "ExternalizationTest{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                '}';
    }
}

class Test{
    public static void main(String[] args) {
        ExternalizationTest externalizationTest=new ExternalizationTest("kk","m",28);
        System.out.println(externalizationTest);
        FileOutputStream fo= null;
        try {
            fo = new FileOutputStream("ext1.txt");
            ObjectOutputStream oos=new ObjectOutputStream(fo);
            oos.writeObject(externalizationTest);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            FileInputStream fileInputStream=new FileInputStream("ext1.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            ExternalizationTest externalizationTest1=(ExternalizationTest) objectInputStream.readObject();
            System.out.println(externalizationTest1);
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
