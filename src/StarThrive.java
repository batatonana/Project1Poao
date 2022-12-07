import java.io.*;
import java.util.ArrayList;
/**
 * Class where the main fucntion is called
 * The "empresas" ArrayList is created in this class
 * 
 * @author Frederico Ferriera 2021217116; Telmo Correia 2019224775 
 * @version 1.0.0
 */
public class StarThrive implements Serializable{

    /**
     * ArrayList for all the "empresas" 
     */
    private ArrayList<Empresa> empresas = new ArrayList<Empresa>();

    /**
     * Constructor responsable for loading data form files into {@link #empresas}
     */
    public StarThrive(){
        readObjFile();
    }

    /**
     * Method that returns the empresa in a specific index
     * @param index the empresa id
     * @return empresa in the index
     */
    public Empresa get(int index){
        return empresas.get(index);
    }

    /**
     * Method that deletes the empresa in a specifici index
     * @param index the empresa id
     * @return 0 if succesfull, -1 if not
     */
    public int delete(int index){
        try {
            empresas.remove(index);
        } catch (Exception e) {
            System.out.println("Unable to delete empresa");
            return -1;
        }
        return 0;
    }

    /**
     * Function to add "Empresas" to the array list
     * @param empresa all info from empresa
     */
    public void add(Empresa empresa){
        try {
            if(empresa.getValid()){
                empresas.add(empresa);
            }else{
                System.out.println(">>>>>>>>>>INFORMACAO INVALIDA<<<<<<<<<<");
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler ficheiro");
        }
    }

    /**
     * Mehtod that puts together data to be displayed by the GUI
     * @return an array of an array of strings with data form the empresa
     */
    public String[][] data(){
        String[][] data = new String[empresas.size()][6];
        int i = 0;
        for (Empresa empresa : empresas) {
            data[i] = empresa.toTable();
            i += 1;
        }
        return data;
    }

    /**
     * Mehtod that returns the 2 biggest restaurants in terms of client capacity
     * @return an array of an array of strings with data form 2 restaaurants
     */
    public String[][] clientes(){
        String data[][] = new String[2][7];
        Empresa maior = empresas.get(0);
        Empresa maior2 = empresas.get(1);
        for (Empresa e : empresas) {
            if (e.capacidadeClientes() > 0 && e.capacidadeClientes() >= maior.capacidadeClientes()){
                maior2 = maior;
                maior = e;
            }
        }
        if(maior.capacidadeClientes() >= 0){
            data[0][0] = maior.toTable()[0];
            data[0][1] = maior.toTable()[1];
            data[0][2] = maior.toTable()[2];
            data[0][3] = String.format("%.2f", maior.capacidadeClientes());
            data[0][4] = maior.toTable()[3];
            data[0][5] = maior.toTable()[4];
            data[0][6] = maior.toTable()[5];
            if(maior2.capacidadeClientes() >= 0){
                data[1][0] = maior2.toTable()[0];
                data[1][1] = maior2.toTable()[1];
                data[1][2] = maior2.toTable()[2];
                data[1][3] = String.format("%.2f", maior2.capacidadeClientes());
                data[1][4] = maior2.toTable()[3];
                data[1][5] = maior2.toTable()[4];
                data[1][6] = maior2.toTable()[5];
            }
        }
        return data;
    }

    /**
     * Mehtod that returns the empresa with the biggest lucro, receita and the smaller despesa depending ont the mode
     * @param mode the mode
     * @return an array of an array of strings with data form empresa with the better stats of each tipe
     */
    public String[][] stats(int mode){
        String[][] data = new String[6][3];
        data[0][1] = "Cafe";
        data[1][1] = "Pastelaria";
        data[2][1] = "Restaurante local";
        data[3][1] = "Restaurante fast-food";
        data[4][1] = "Frutaria";
        data[5][1] = "Mercado";
        for (int i = 0; i < data.length; i++) {
            data[i][0] = "NOT FOUND";
            data[i][2] = "-1";
        }
        for (Empresa empresa : empresas) {
            switch (mode) {
                case 0:
                    if(empresa.lucroAnual() > Double.parseDouble(data[empresa.getTipo()][2].replaceAll(",", "."))){
                        data[empresa.getTipo()][0] = empresa.getName();
                        data[empresa.getTipo()][2] = String.format("%.2f",empresa.lucroAnual());
                    }
                    break;
                case 1:
                    if(empresa.receitaAnual() > Double.parseDouble(data[empresa.getTipo()][2].replaceAll(",", "."))){
                        data[empresa.getTipo()][0] = empresa.getName();
                        data[empresa.getTipo()][2] = String.format("%.2f",empresa.receitaAnual());
                    }
                    break;
                case 2:
                    if(Double.parseDouble(data[empresa.getTipo()][2].replaceAll(",", ".")) == -1){
                        data[empresa.getTipo()][0] = empresa.getName();
                        data[empresa.getTipo()][2] = String.format("%.2f",empresa.despesaAnual());
                    }
                    else if(empresa.despesaAnual() < Double.parseDouble(data[empresa.getTipo()][2].replaceAll(",", "."))){
                        data[empresa.getTipo()][0] = empresa.getName();
                        data[empresa.getTipo()][2] = String.format("%.2f",empresa.despesaAnual());
                    }
                    break;
                }
        }
        return data;
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
                    try{
                    switch (type) {
                        case 0:
                            empresa = new Cafe(attributes[1], Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]), attributes[4], Integer.parseInt(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[7]), Double.parseDouble(attributes[8]), Double.parseDouble(attributes[9]));
                            add(empresa);
                            break;
                        case 1:
                            empresa = new Pastelaria(attributes[1], Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]), attributes[4], Integer.parseInt(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[7]), Double.parseDouble(attributes[8]), Double.parseDouble(attributes[9]));
                            add(empresa);
                            break;
                        case 2:
                            empresa = new Local(attributes[1], Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]), attributes[4], Integer.parseInt(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[7]), Integer.parseInt(attributes[8]),  Integer.parseInt(attributes[9]), Double.parseDouble(attributes[10]) , Integer.parseInt(attributes[11]), Double.parseDouble(attributes[12]));
                            add(empresa);
                            break;
                        case 3:
                            empresa = new FastFood(attributes[1], Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]), attributes[4], Integer.parseInt(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[7]), Integer.parseInt(attributes[8]),  Integer.parseInt(attributes[9]), Double.parseDouble(attributes[10]) , Double.parseDouble(attributes[11]), Double.parseDouble(attributes[12]));
                            add(empresa);
                            break;
                        case 4:
                            empresa = new Frutaria(attributes[1], Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]), attributes[4], Double.parseDouble(attributes[5]), Integer.parseInt(attributes[6]), Double.parseDouble(attributes[7]));
                            add(empresa);
                            break;
                        case 5:
                            empresa = new Mercado(attributes[1], Double.parseDouble(attributes[2]), Double.parseDouble(attributes[3]), attributes[4], Double.parseDouble(attributes[5]), attributes[6], Double.parseDouble(attributes[7]), Double.parseDouble(attributes[8]));
                            add(empresa);
                            break;
                    }}catch(Exception e){
                        System.out.println("Error Reading a line");
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
     * Function to read data from the .obj file.
     * If object file is not found calls the function {@link #readFile()}
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
    
    /**
     * Function main to run program
     * @param args main args
     */
    public static void main(String[] args) {
        StarThrive manager = new StarThrive();
        new LoadMain(manager);
    }
}
