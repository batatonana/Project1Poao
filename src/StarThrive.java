/**
 * Class where the main function is run
 */

import java.util.ArrayList;

import Empresas.Cafe;
import Empresas.Empresa;
import Empresas.Local;
import Empresas.Pastelaria;
import GUI.LandingPage;

public class StarThrive {
    private ArrayList<Empresa> empresas = new ArrayList<Empresa>();

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
    public static void main(String[] args) {
        new LandingPage();
        StarThrive manager = new StarThrive();

        Empresa empresa = new Cafe("McDonal", -10, -10, "Leiria", 10, 12000, 1200, 4000, 400);
        manager.add(empresa);
        empresa = new Cafe("McDonal1", -180, -10, "Leiria", 10, 12000, 1200, 4000, 400);
        manager.add(empresa);
        empresa = new Cafe("McDonal2", -10, -1000, "Leiria", 10, 12000, 1200, 4000, 400);
        manager.add(empresa);
        empresa = new Cafe("McDonal3", -10, -1000, "leiria", 1, 12000, 1200, 4000, 400);
        manager.add(empresa);
        empresa = new Cafe("McDonal4", -10, -1000, "Leiria", -1, 12000, 1200, 4000, 400);
        manager.add(empresa);
        empresa = new Cafe("McDonal5", -10, -1000, "Leiria", 10, -1, 1200, 4000, 400);
        manager.add(empresa);
        empresa = new Cafe("McDonal6", -10, -1000, "Leiria", 10, 12000, -1, 4000, 400);
        manager.add(empresa);
        empresa = new Cafe("McDonal7", -10, -1000, "Leiria", 10, 12000, 1200, -1, 400);
        manager.add(empresa);
        empresa = new Cafe("McDonal8", -10, -1000, "Leiria", 10, 12000, 1200, 4000, -1);
        manager.add(empresa);
        
        empresa = new Pastelaria("McDonal9", -180, -10, "Leiria", 10, 12000, 1200, 4000, 400);
        manager.add(empresa);
        empresa = new Pastelaria("McDonal10", -10, -1000, "Leiria", 10, 12000, 1200, 4000, 400);
        manager.add(empresa);
        empresa = new Pastelaria("McDonal11", -10, -1000, "leiria", 1, 12000, 1200, 4000, 400);
        manager.add(empresa);
        empresa = new Pastelaria("McDona12", -10, -1000, "Leiria", -1, 12000, 1200, 4000, 400);
        manager.add(empresa);
        empresa = new Pastelaria("McDonal13", -10, -1000, "Leiria", 10, -1, 1200, 4000, 400);
        manager.add(empresa);
        empresa = new Pastelaria("McDonal14", -10, -1000, "Leiria", 10, 12000, -1, 4000, 400);
        manager.add(empresa);
        empresa = new Pastelaria("McDonal15", -10, -1000, "Leiria", 10, 12000, 1200, -1, 400);
        manager.add(empresa);
        empresa = new Pastelaria("McDonal16", -10, -1000, "Leiria", 10, 12000, 1200, 4000, -1);
        manager.add(empresa);
        empresa = new Pastelaria("McDonal17", -10, -10, "Leiria", 10, 12000, 1200, 4000, 400);
        manager.add(empresa);

        empresa = new Local("McDonal19", -19, -10, "Coimbra", 10, 10, 40, 300, 10, 10, 10, 10);
        manager.add(empresa);
        empresa = new Local("McDonal20", -19, -10, "Coimbra", 10, 10, 40, 300, 10, -1, 10, 10);
        manager.add(empresa);
        empresa = new Local("McDonal21", -19, -10, "Coimbra", 10, 10, 40, 300, -1, 10, 10, 10);
        manager.add(empresa);
        empresa = new Local("McDonal22", -19, -10, "Coimbra", 10, 10, 40, -1, 10, 10, 10, 10);
        manager.add(empresa);
        empresa = new Local("McDonal19", -19, -10, "Coimbra", 10, 10, 40, 300, 10, 10, -1, 10);
        manager.add(empresa);


        manager.print();

    }
}
