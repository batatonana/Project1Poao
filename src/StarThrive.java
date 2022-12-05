/**
 * Class where the main function is run
 */
import java.io.*;
import java.util.ArrayList;

public class StarThrive implements Serializable{
    //Array for all the "Empresas"
    private ArrayList<Empresa> empresas = new ArrayList<Empresa>();

    /**
     * Function to add "Empresas" to the array list
     * @param empresa
     */
    public void add(Empresa empresa){
        if(empresa.getValid()){
            empresas.add(empresa);
        }else{
            System.out.println(">>>>>>>>>>INFORMACAO INVALIDA<<<<<<<<<<");
        }
    }

    public void print(){
        for (Empresa empresa : empresas) {
            System.out.println(empresa);
        }
    }

    public void printClientes(){
        Empresa maior = empresas.get(0);
        Empresa maior2 = empresas.get(1);
        for (Empresa e : empresas) {
            if (e.capacidadeClientes() > 0 && e.capacidadeClientes() >= maior.capacidadeClientes()){
                maior2 = maior;
                maior = e;
            }
        }
        System.out.println("AQUIIIIIIIIIIIIIIIii");
        if(maior.capacidadeClientes() >= 0){
            System.out.println(maior);
            if(maior2.capacidadeClientes() >= 0){
                System.out.println(maior2);
            }
        }
    }

    /**
     * Function used to save data to a .obj file
     */
    public void saveFile(){
        File f = new File("Empresas.dat");
        
        try{
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(empresas);

            oos.close();
        }catch(FileNotFoundException e){
            System.out.println("Error creating file");
        }catch(IOException e){
            System.out.println("Error writing on file");
        }
    }

    /**
     * Function to read data from o .txt file
     */
    // ! check visisbility
    private void readFile() {
        File f = new File("Empresas.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            Empresa empresa;
            String l;
            int type;
            while((l = br.readLine()) != null){
                l = l.strip();
                if(l.charAt(0) >= '0' && l.charAt(0)<='5'){
                    type = Integer.parseInt(l.substring(0, 1));
                    String[] attributes = l.split(";", 0);
                    switch (type) {
                        case 0:
                            empresa = new Cafe(attributes[1], Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]), attributes[4], Integer.parseInt(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[7]), Double.parseDouble(attributes[8]), Double.parseDouble(attributes[9]));
                            empresas.add(empresa);
                            break;
                        case 1:
                            empresa = new Pastelaria(attributes[1], Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]), attributes[4], Integer.parseInt(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[7]), Double.parseDouble(attributes[8]), Double.parseDouble(attributes[9]));
                            empresas.add(empresa);
                            break;
                        case 2:
                            empresa = new Local(attributes[1], Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]), attributes[4], Integer.parseInt(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[7]), Integer.parseInt(attributes[8]),  Integer.parseInt(attributes[9]), Double.parseDouble(attributes[10]) , Integer.parseInt(attributes[11]), Double.parseDouble(attributes[12]));
                            empresas.add(empresa);
                            break;
                        case 3:
                            empresa = new Fast_Food(attributes[1], Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]), attributes[4], Integer.parseInt(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[7]), Integer.parseInt(attributes[8]),  Integer.parseInt(attributes[9]), Double.parseDouble(attributes[10]) , Double.parseDouble(attributes[11]), Double.parseDouble(attributes[12]));
                            empresas.add(empresa);
                            break;
                        case 4:
                            empresa = new Frutaria(attributes[1], Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]), attributes[4], Double.parseDouble(attributes[5]), Integer.parseInt(attributes[6]), Double.parseDouble(attributes[7]));
                            empresas.add(empresa);
                            break;
                        case 5:
                            empresa = new Mercado(attributes[1], Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]), attributes[4], Double.parseDouble(attributes[5]), attributes[6], Double.parseDouble(attributes[7]), Double.parseDouble(attributes[8]));
                            empresas.add(empresa);
                            break;
                    }
                }
            }
            br.close();
            saveFile();
        } catch (FileNotFoundException e) {
            System.out.println("No file foound");
        } catch(IOException e){
            System.out.println("Error reading file");
        }
    }

    /**
     * Function to data from the .obj file.
     * If object file is not found calls the function {@link readFile()}
     */
    public void readObjFile(){
        File obj = new File("Empresas.dat");
        try{
            System.out.println("File found and opened");
            FileInputStream fis = new FileInputStream(obj);
            ObjectInputStream ois = new ObjectInputStream(fis);

           this.empresas = (ArrayList<Empresa>)ois.readObject();

           ois.close();
        }catch(FileNotFoundException e){
            readFile();
        }catch(IOException e){
            System.out.println("Error reading file");
        }catch(ClassNotFoundException e){
            System.out.println("Class not founf");
        }
    }
    
    public static void main(String[] args) {
        new LandingPage();
        StarThrive manager = new StarThrive();
        manager.readObjFile();
        manager.print();
        manager.printClientes();
    }
}
