//PROJETO - Marta Carreira Santos 2019220054
package cisuc;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main Program
 */
public class CISUC {

    ArrayList<Investigadores> investigador;
    ArrayList<Publicacoes> publicacao;
    ArrayList<Grupos> grupo;

    public static void main(String[] args) {
        new CISUC();
    }

    public CISUC()  {

        investigador = new ArrayList<>();
        publicacao = new ArrayList<>();
        grupo = new ArrayList<>();

        blackBoxTest(1);

        /*
        if (lerObj() == 0) {
            lerTxt1();
            lerTxt2();
            //lerTxt3();
            escreverObj();
        }
        Scanner sc = new Scanner(System.in);
        int escolha = 6;
        while (escolha != 0) {

            System.out.println("0 - Sair");
            System.out.println("1 - Apresentar os indicadores gerias do CISUC");
            System.out.println("2 - Listar publicacoes de um grupo de investigacao");
            System.out.println("3 - Listar membros de um grupo de investigacao");
            System.out.println("4 - Listar publicacoes de um investigador");
            System.out.println("5 - Listar todos os grupos de investigacao");
            System.out.print("Escolha: ");
            escolha = sc.nextInt();
            switch (escolha) {

                case 1:
                    indicadorGeral();
                    break;
                case 2:
                    listarGrupo();
                    break;
                case 3:
                    listarMembro();
                    break;
                case 4:
                    listarInvestigador();
                    break;
                case 5:
                    listarTGrupos();
                    break;
                case 0:
                    System.exit(0);
            }
        }
        sc.close();*/
    }

    /***
     * DEGUG
     * @param i
     */
    public void blackBoxTest(int i){

        File folder;
        String fileName;

        //lerTxt1("grupos.txt");
        lerTxt1("grupos/gruposMm.txt");
        lerTxt2();


        if(i == 0){ //Complexity 7

            folder = new File("input_data/blackBox0/");

            try{
                for (final File fileEntry: folder.listFiles()){
                    if (fileEntry.isFile()){
                        fileName =  fileEntry.getName();

                        System.out.println(fileName);

                        if(!fileName.equals("publicacoes.txt")){
                            continue;
                        }

                        //PrintStream fileOut = new PrintStream("output_data/blackBox0/" + fileName);
                        //System.setOut(fileOut);

                        try {

                            FileReader fr3 = new FileReader(fileEntry);
                            BufferedReader br3 = new BufferedReader(fr3);

                            test0(br3);

                            br3.close();
                            fr3.close();

                        } catch (FileNotFoundException ex) {
                            System.err.println("Erro ao abrir o ficheiro de texto.");
                        } catch (IOException ex) {
                            System.err.println("Erro a ler o ficheiro de texto.");
                        } catch (Exception e) {
                            System.err.println(e);
                        }

                        //fileOut.close();
                    }
                }
            }
            catch (Exception e){
                System.out.println(e);
            }

        }
        else if(i == 1) { //Complexity 6

            folder = new File("input_data/blackBox1/");

            try{
                for (final File fileEntry: folder.listFiles()){
                    if (fileEntry.isFile()){
                        fileName =  fileEntry.getName();

                        System.out.println(fileName);

                        //PrintStream fileOut = new PrintStream("output_data/blackBox1/" + fileName);
                        //System.setOut(fileOut);

                        test1();

                        //fileOut.close();

                    }
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

    }

    /**
     * DEBUG - FUNCAO TESTE 0
     * Verifica se pelo menos um dos autores existe
     */
    public void test0(BufferedReader br3) throws Exception{

        String line3;
        int numLine = 0;

        while ((line3 = br3.readLine()) != null) {
            numLine += 1;

            String[] cortado3 = line3.split("&&&");
            String[] autores = cortado3[1].split(",");
            String nomeGrupo = cortado3[2];
            int aux = 0;

            for (Grupos j : grupo) {
                if (j.getAcronimo().equals(nomeGrupo)) {
                    if (j.getInvResp().equals(autores[0]) || j.getInvResp().equals(autores[1]) || j.getInvResp().equals(autores[2])) {
                        aux = 1;
                    }
                    String[] membros = j.getListaMembros();
                    for (String nome : membros) {
                        if (nome.equals(autores[0]) || nome.equals(autores[1]) || nome.equals(autores[2])) {
                            aux = 1;
                        }
                    }
                }
            }
            System.out.println(aux);
        }
    }

    /**
     * DEBUG - FUNCAO TESTE 1
     * //b) Number of members of each category (gryp)
     */
    public void test1(){

        for (Grupos g2 : grupo) {
            int numM = 0, numE = 0;
            String[] listaMembros = g2.getListaMembros();
            for (String membro : listaMembros) {
                for (Investigadores i : investigador) {
                    if (membro.equals(i.getNome())) {
                        if (i.isInv().equals("M")) {
                            numM += 1; //effective member
                        }
                        else {
                            numE += 1; //student
                        }
                    }
                }
            }
            System.out.println("\t" + g2.getAcronimo() + " - \tMembros efetivos: " + numM + "\n\t\tEstudantes: " + numE);
        }
    }

    /**
     * Read the text file 'grupos.txt' and add to the ArrayList 'grupo'
     */
    public void lerTxt1(String nameFile) {
        String line1;

        File fich1 = new File(nameFile);
        if (fich1.exists() && fich1.isFile()) {
            try {
                FileReader fr1 = new FileReader(fich1);
                BufferedReader br1 = new BufferedReader(fr1);

                while ((line1 = br1.readLine()) != null) {
                    String[] cortado1 = line1.split(",,");
                    String[] listaMembros = cortado1[3].split(";;");
                    Grupos g1 = new Grupos(cortado1[0], cortado1[1], cortado1[2], listaMembros);
                    grupo.add(g1);
                }
            } catch (FileNotFoundException ex) {
                System.err.println("Erro ao abrir o ficheiro de texto.");
            } catch (IOException ex) {
                System.err.println("Erro a ler o ficheiro de texto.");
            }
        }
    }

    /**
     * Read the text file 'investigadores.txt' and add to the ArrayList 'investigador'
     */
    public void lerTxt2() {
        String line2;

        File fich2 = new File("investigadores.txt");
        if (fich2.exists() && fich2.isFile()) {
            try {
                FileReader fr2 = new FileReader(fich2);
                BufferedReader br2 = new BufferedReader(fr2);

                while ((line2 = br2.readLine()) != null) {
                    String[] cortado2 = line2.split("#");
                    if (cortado2[0].equals("M")) {          //effective member
                        int num = Integer.parseInt(cortado2[5]);
                        Investigadores v1 = new Membro(cortado2[1], cortado2[2], cortado2[3], cortado2[4], num);
                        investigador.add(v1);
                    }
                    if (cortado2[0].equals("E")) {          //student
                        String[] data = cortado2[5].split("/");
                        int[] data2 = new int[3];
                        data2[0] = Integer.parseInt(data[0]);
                        data2[1] = Integer.parseInt(data[1]);
                        data2[2] = Integer.parseInt(data[2]);
                        //Checks if the orientation investigator is in the same group as the student
                        String invOrientador = cortado2[6];
                        int aux2 = 0;
                        for (Grupos g : grupo) {
                            if (g.getAcronimo().equals(cortado2[3])) {
                                String[] membros = g.getListaMembros();
                                if (g.getInvResp().equals(invOrientador)) {
                                    aux2 = 1;
                                }
                                for (String nome : membros) {
                                    if (nome.equals(invOrientador)) {
                                        aux2 = 1;
                                    }
                                }
                            }
                        }
                        if (aux2 == 0) {
                            System.err.println("O investigador orientador nao pertence ao mesmo grupo que o estudante.");
                        } else {
                            Investigadores v2 = new Estudante(cortado2[1], cortado2[2], cortado2[3], cortado2[4], data2, invOrientador);
                            investigador.add(v2);
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                System.err.println("Erro ao abrir o ficheiro de texto.");
            } catch (IOException ex) {
                System.err.println("Erro a ler o ficheiro de texto.");
            }
        } else {
            System.err.println("O ficheiro não existe.");
        }
    }

    /**
     * Read the text file 'publicacoes.txt' and add to the ArrayList 'publicacao'
     */
    public void lerTxt3() {
        String line3;
        int numLine = 0;

        File fich3 = new File("publicacoes.txt");

        if (fich3.exists() && fich3.isFile()) {
            try {
                FileReader fr3 = new FileReader(fich3);
                BufferedReader br3 = new BufferedReader(fr3);

                while ((line3 = br3.readLine()) != null) {
                    numLine += 1;

                    String[] cortado3 = line3.split("&&&");
                    String[] autores = cortado3[1].split(",");
                    String nomeGrupo = cortado3[2];
                    int aux = 0;
                    //Checks if at least 1 author is in the group of the publication
                    for (Grupos j : grupo) {
                        if (j.getAcronimo().equals(nomeGrupo)) {
                            if (j.getInvResp().equals(autores[0]) || j.getInvResp().equals(autores[1]) || j.getInvResp().equals(autores[2])) {
                                aux = 1;
                            }
                            String[] membros = j.getListaMembros();
                            for (String nome : membros) {
                                if (nome.equals(autores[0]) || nome.equals(autores[1]) || nome.equals(autores[2])) {
                                    aux = 1;
                                }
                            }
                        }
                    }

                    if (aux == 0) {
                        System.err.println("Erro na linha " + numLine + " do ficheiro 'publicacoes.txt'\nNenhum dos autores da publicacao pertence ao grupo");
                        break;
                    }
                    int num = Integer.parseInt(cortado3[0]);
                    int ano = Integer.parseInt(cortado3[5]);
                    int audiencia = Integer.parseInt(cortado3[6]);
                    if (num == 1) {   //conference article
                        String[] data11 = cortado3[9].split("/");
                        int[] data1 = new int[3];
                        data1[0] = Integer.parseInt(data11[0]);
                        data1[1] = Integer.parseInt(data11[1]);
                        data1[2] = Integer.parseInt(data11[2]);

                        Publicacoes v1 = new Conferencia(autores, cortado3[2], cortado3[3], cortado3[4], ano, audiencia, cortado3[7], cortado3[8], data1, cortado3[10]);
                        publicacao.add(v1);
                    }
                    if (num == 2) {   //magazine article
                        String[] data22 = cortado3[9].split("/");
                        int[] data2 = new int[3];
                        data2[0] = Integer.parseInt(data22[0]);
                        data2[1] = Integer.parseInt(data22[1]);
                        data2[2] = Integer.parseInt(data22[2]);
                        int numRevista = Integer.parseInt(cortado3[10]);

                        Publicacoes v2 = new Revista(autores, cortado3[2], cortado3[3], cortado3[4], ano, audiencia, cortado3[7], cortado3[8], data2, numRevista);
                        publicacao.add(v2);
                    }
                    if (num == 3) {   //book article
                        int isbn1 = Integer.parseInt(cortado3[9]);

                        Publicacoes v3 = new Livro(autores, cortado3[2], cortado3[3], cortado3[4], ano, audiencia, cortado3[7], cortado3[8], isbn1);
                        publicacao.add(v3);
                    }
                    if (num == 4) {   //chapter book article
                        int isbn2 = Integer.parseInt(cortado3[9]);
                        int pagInicial = Integer.parseInt(cortado3[11]);
                        int pagFinal = Integer.parseInt(cortado3[12]);

                        Publicacoes v4 = new Capitulo(autores, cortado3[2], cortado3[3], cortado3[4], ano, audiencia, cortado3[7], cortado3[8], isbn2, cortado3[10], pagInicial, pagFinal);
                        publicacao.add(v4);
                    }
                    if (num == 5) {   //conference book article
                        int isbn3 = Integer.parseInt(cortado3[9]);
                        int artigos = Integer.parseInt(cortado3[11]);

                        Publicacoes v4 = new LivroConferencia(autores, cortado3[2], cortado3[3], cortado3[4], ano, audiencia, cortado3[7], cortado3[8], isbn3, cortado3[10], artigos);
                        publicacao.add(v4);
                    }
                }
            } catch (FileNotFoundException ex) {
                System.err.println("Erro ao abrir o ficheiro de texto.");
            } catch (IOException ex) {
                System.err.println("Erro a ler o ficheiro de texto.");
            }
        }
    }

    /**
     * Write in object file the Arraylist 'investigador', 'grupo' and 'publicacao'
     */
    public void escreverObj() {
        File fichObj = new File("final.obj");
        try {
            FileOutputStream fs = new FileOutputStream(fichObj);
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(investigador);
            os.writeObject(grupo);
            os.writeObject(publicacao);
            os.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Erro a criar ficheiro de objetos.");
        } catch (IOException ex) {
            System.err.println("Erro a escrever para o ficheiro de objetos.");
        }
    }

    /**
     * Read the object file and save the object in the respective ArrayList
     * @return 1 if can open, read the file and convert the object, else return 0
     */
    public int lerObj() {
        File fichObj = new File("final.obj");

        try {
            FileInputStream fi = new FileInputStream(fichObj);
            ObjectInputStream oi = new ObjectInputStream(fi);

            investigador = (ArrayList<Investigadores>) oi.readObject();
            grupo = (ArrayList<Grupos>) oi.readObject();
            publicacao = (ArrayList<Publicacoes>) oi.readObject();
            oi.close();
            return 1;
        } catch (FileNotFoundException ex) {
            System.err.println("Erro ao abrir o ficheiro de objetos.");
        } catch (IOException ex) {
            System.err.println("Erro ao ler o ficheiro de objetos.");
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro a converter o obejto.");
        }
        return 0;
    }

    /**
     * 1 - Prints the geral indicators of CISUC: 
     * a) Members total
     * b) Members total of each category
     * c) Publications total of the last 5 years
     * d) Number of publications of each type
     */
    public void indicadorGeral() {
        //a) Members total
        int membros = investigador.size();
        System.out.println("\na) Total de membros: " + membros);

        //b) Members total of each category
        System.out.println("b) Nº total de membros de cada categoria:");
        int numM = 0, numE = 0;
        for (Investigadores i : investigador) {
            if (i.isInv().equals("M")) {        //effective member
                numM += 1;
            }
            if (i.isInv().equals("E")) {        //student
                numE += 1;
            }
        }
        System.out.println("\tMembros efetivos: " + numM + "\n\tEstudantes: " + numE);

        //c) Publications total of the last 5 years
        int num = 0;
        for (Publicacoes j : publicacao) {
            if (j.anoPub >= 2015) {
                num += 1;
            }
        }
        System.out.println("c) Total de publicações dos últimos 5 anos: " + num);

        //d) Number of publications of each type
        System.out.println("d) Número de publicações de cada tipo:");
        int p1 = 0, p2 = 0, p3 = 0, p4 = 0, p5 = 0;
        for (Publicacoes k : publicacao) {
            if (k.isArticle() == 1) {     //Conference Article
                p1 += 1;
            }
            if (k.isArticle() == 2) {     //Magazine Article
                p2 += 1;
            }
            if (k.isArticle() == 3) {     //Book Article
                p3 += 1;
            }
            if (k.isArticle() == 4) {     //Book Shapter Article
                p4 += 1;
            }
            if (k.isArticle() == 5) {     //Conference Book Article
                p5 += 1;
            }
        }
        System.out.println("\tPublicacoes artigo de conferência: " + p1 + "\n\tPublicacoes artigo de revista: " + p2 + "\n\tPublicacoes livro: " + p3 + "\n\tPublicacoes capitulos livro: " + p4 + "\n\tPublicacoes livro de artigos de conferência: " + p5 + "\n");
    }

    /**
     * 2 - Lists the publications of an investigation group from the last 5 years
     * Organized by year, by type of publication and by impact factor
     */
    public void listarGrupo() {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("\nIntroduza o acronimo do grupo: ");
        String acronimo = sc1.nextLine();

        if (acronimo.equals("AC") || acronimo.equals("CMS") || acronimo.equals("ECOS") || acronimo.equals("IS") || acronimo.equals("LCT") || acronimo.equals("SSE")) {

            for (int ano = 2020; ano >= 2015; ano--) {
                String[] pubConf = new String[3];
                String[] pubRevista = new String[3];
                String[] pubLivro = new String[3];
                String[] pubLivroCap = new String[3];
                String[] pubLivroConf = new String[3];

                for (Publicacoes pub : publicacao) {
                    if (pub.getGrupo().equals(acronimo)) {
                        if (pub.getAnoPub() == ano) {
                            //Checks if the authors is an effective member or a student
                            String[] aut = pub.getAutores();
                            String autores = verificaAutores(aut);

                            //Adds the publication organized by type of publication and impact factor
                            if (pub.isArticle() == 1) {  //Conference Article
                                pubConf = adiciona(pub.calculaFator(), pubConf, autores, pub.toString());
                            }
                            if (pub.isArticle() == 2) {  //Magazine Article
                                pubRevista = adiciona(pub.calculaFator(), pubRevista, autores, pub.toString());
                            }
                            if (pub.isArticle() == 3) {  //Book Article
                                pubLivro = adiciona(pub.calculaFator(), pubLivro, autores, pub.toString());
                            }
                            if (pub.isArticle() == 4) {  //Book Shapter Article
                                pubLivroCap = adiciona(pub.calculaFator(), pubLivroCap, autores, pub.toString());
                            }
                            if (pub.isArticle() == 5) {  //Conference Book Article
                                pubLivroConf = adiciona(pub.calculaFator(), pubLivroConf, autores, pub.toString());
                            }
                        }
                    }
                }

                //Prints all the publications agrouped by year, type of publication and impact factor
                if (pubConf[0] == null && pubConf[1] == null && pubConf[2] == null && pubRevista[0] == null && pubRevista[1] == null
                        && pubRevista[2] == null && pubLivro[0] == null && pubLivro[1] == null && pubLivro[2] == null && pubLivroCap[0] == null
                        && pubLivroCap[1] == null && pubLivroCap[2] == null && pubLivroConf[0] == null && pubLivroConf[1] == null && pubLivroConf[2] == null) {
                } 
                else {
                    System.out.println("\n--------------------- Ano " + ano + " ---------------------");
                }
                if (pubConf[0] != null || pubConf[1] != null || pubConf[2] != null) {
                    System.out.println("\n* * * * * Conferencia * * * * *");
                    imprimirPub(pubConf);
                }
                if (pubRevista[0] != null || pubRevista[1] != null || pubRevista[2] != null) {
                    System.out.println("\n* * * * * Revista * * * * *");
                    imprimirPub(pubRevista);
                }
                if (pubLivro[0] != null || pubLivro[1] != null || pubLivro[2] != null) {
                    System.out.println("\n* * * * * Livro * * * * *");
                    imprimirPub(pubLivro);
                }
                if (pubLivroCap[0] != null || pubLivroCap[1] != null || pubLivroCap[2] != null) {
                    System.out.println("\n* * * * * Capitulo Livro * * * * *");
                    imprimirPub(pubLivroCap);
                }
                if (pubLivroConf[0] != null || pubLivroConf[1] != null || pubLivroConf[2] != null) {
                    System.out.println("\n* * * * * Livro Artigos Conferencia * * * * *");
                    imprimirPub(pubLivroConf);
                }
            }
            System.out.println("");
        } else {
            System.err.println("O grupo que introduziu não existe.");
        }
    }

    /**
     * 3 - List the members of 1 investigation group grouped by category
     */
    public void listarMembro() {
        Scanner sc2 = new Scanner(System.in);
        System.out.print("\nIntroduza o acronimo do grupo: ");
        String acronimo2 = sc2.nextLine();
        if (acronimo2.equals("AC") || acronimo2.equals("CMS") || acronimo2.equals("ECOS") || acronimo2.equals("IS") || acronimo2.equals("LCT") || acronimo2.equals("SSE")) {
            String[] efetivos = new String[50];
            String[] estudantes = new String[50];
            int auxM = 0, auxE = 0;
            for (Grupos g : grupo) {
                if (g.getAcronimo().equals(acronimo2)) {
                    String invResp = g.getInvResp();
                    String[] membros = g.getListaMembros();
                    if (auxM == 0) {      //add the responsible investigator to the array 'efetivos6
                        String[] nome0 = invResp.split(" ");
                        int comp0 = nome0.length;
                        efetivos[auxM] = "Professor " + nome0[0] + " " + nome0[comp0 - 1];
                        auxM += 1;
                    }
                    for (String m : membros) {
                        for (Investigadores i : investigador) {
                            if (i.getNome().equals(m)) {
                                if (i.isInv().equals("M")) {   //effective member
                                    String[] nome1 = m.split(" ");
                                    int comp1 = nome1.length;
                                    efetivos[auxM] = "Professor " + nome1[0] + " " + nome1[comp1 - 1];
                                    auxM += 1;
                                }
                                if (i.isInv().equals("E")) {   //student
                                    String[] nome2 = m.split(" ");
                                    String[] letras = nome2[0].split("");
                                    int comp2 = nome2.length;
                                    estudantes[auxE] = letras[0] + ". " + nome2[comp2 - 1];
                                    auxE += 1;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("Membros do grupo de investigacao " + acronimo2 + ":");
            System.out.println("\tMembros efetivos:");
            for (int a = 0; a < efetivos.length; a++) {
                if (efetivos[a] != null) {
                    System.out.println("\t   " + efetivos[a]);
                }
            }
            System.out.println("\tEstudantes:");
            for (int b = 0; b < estudantes.length; b++) {
                if (estudantes[b] != null) {
                    System.out.println("\t   " + estudantes[b]);
                }
            }
            System.out.println("");

        } else {
            System.err.println("O grupo que introduziu não existe.");
        }

    }

    /**
     * 4 - List the publications of an investigator grouped by year, type of publication and impact factor
     */
    public void listarInvestigador() {
        Scanner sc4 = new Scanner(System.in);
        System.out.print("\nIntroduza o nome do investigador:");
        String nomeInv = sc4.nextLine();
        int aux1 = 0, aux2 = 0;
        for (Investigadores i : investigador) {
            if (nomeInv.equals(i.getNome())) {
                aux1 = 1;
                for (int ano = 2020; ano > 0; ano--) {
                    String[] pubConf = new String[3];
                    String[] pubRevista = new String[3];
                    String[] pubLivro = new String[3];
                    String[] pubLivroCap = new String[3];
                    String[] pubLivroConf = new String[3];
                    String autores;
                    for (Publicacoes p : publicacao) {
                        String[] listaAutores = p.getAutores();
                        for (String autor : listaAutores) {
                            if (autor.equals(nomeInv)) {
                                aux2 = 1;
                                if (ano == p.getAnoPub()) {
                                    autores = verificaAutores(listaAutores);

                                    //Adds the publication organized by type of publication and impact facto
                                    if (p.isArticle() == 1) {  //Conference Article
                                        pubConf = adiciona(p.calculaFator(), pubConf, autores, p.toString());
                                    }
                                    if (p.isArticle() == 2) {  //Magazine Article
                                        pubRevista = adiciona(p.calculaFator(), pubRevista, autores, p.toString());
                                    }
                                    if (p.isArticle() == 3) {  //Book Article
                                        pubLivro = adiciona(p.calculaFator(), pubLivro, autores, p.toString());
                                    }
                                    if (p.isArticle() == 4) {  //Book Shapter Article
                                        pubLivroCap = adiciona(p.calculaFator(), pubLivroCap, autores, p.toString());
                                    }
                                    if (p.isArticle() == 5) {  //Conference Book Article
                                        pubLivroConf = adiciona(p.calculaFator(), pubLivroConf, autores, p.toString());
                                    }
                                }
                            }
                        }
                    }
                    //Prints all the publications of the investigator
                    if (pubConf[0] == null && pubConf[1] == null && pubConf[2] == null && pubRevista[0] == null && pubRevista[1] == null
                            && pubRevista[2] == null && pubLivro[0] == null && pubLivro[1] == null && pubLivro[2] == null && pubLivroCap[0] == null
                            && pubLivroCap[1] == null && pubLivroCap[2] == null && pubLivroConf[0] == null && pubLivroConf[1] == null && pubLivroConf[2] == null) {
                    } else {
                        System.out.println("\n------------> Ano " + ano);
                    }
                    if (pubConf[0] != null || pubConf[1] != null || pubConf[2] != null) {
                        System.out.println("- - - -> Conferencia");
                        imprimirPub(pubConf);
                    }
                    if (pubRevista[0] != null || pubRevista[1] != null || pubRevista[2] != null) {
                        System.out.println("- - - -> Revista");
                        imprimirPub(pubRevista);
                    }
                    if (pubLivro[0] != null || pubLivro[1] != null || pubLivro[2] != null) {
                        System.out.println("- - - -> Livro");
                        imprimirPub(pubLivro);
                    }
                    if (pubLivroCap[0] != null || pubLivroCap[1] != null || pubLivroCap[2] != null) {
                        System.out.println("- - - -> Capitulo Livro");
                        imprimirPub(pubLivroCap);
                    }
                    if (pubLivroConf[0] != null || pubLivroConf[1] != null || pubLivroConf[2] != null) {
                        System.out.println("- - - -> Livro Artigos Conferencia");
                        imprimirPub(pubLivroConf);
                    }
                }
                System.out.println("");
            }
        }
        if (aux1 == 0) {
            System.out.println("O investigador que introduziu nao existe na CISUC.");
        }
        if (aux2 == 0) {
            System.out.println("O investigador que introduziu nao contem nenhuma publicacao.");
        }
    }

    /**
     * 5 - List all the groups of investigation, and presents: 
     * a) Members total
     * b) Number of members of each category 
     * c) Total of publications on the last 5 years
     * d) Number of publications of the last 5 years, grouped by year, type of publication and impact factor
     */
    public void listarTGrupos() {
        //a) Members total
        System.out.println("\na) Total de membros:");
        for (Grupos g1 : grupo) {
            String[] listaMembros = g1.getListaMembros();
            int membros = listaMembros.length + 1;       //+1 because of the responsable investigator
            System.out.println("\t" + g1.getAcronimo() + ": " + membros + " membros");
        }

        //b) Number of members of each category
        System.out.println("b) Numero de membros de cada categoria:");
        for (Grupos g2 : grupo) {
            int numM = 0, numE = 0;
            String[] listaMembros = g2.getListaMembros();
            for (String membro : listaMembros) {
                for (Investigadores i : investigador) {
                    if (membro.equals(i.getNome())) {
                        if (i.isInv().equals("M")) {
                            numM += 1; //effective member
                        }
                        else {
                            numE += 1; //student
                        }
                    }
                }
            }
            System.out.println("\t" + g2.getAcronimo() + " - \tMembros efetivos: " + numM + "\n\t\tEstudantes: " + numE);
        }

        //c) Total of publications on the last 5 years
        System.out.println("c) Total de publicacoes dos ultimos 5 anos:");
        for (Grupos g3 : grupo) {
            int total = 0;
            for (Publicacoes p : publicacao) {
                if (g3.getAcronimo().equals(p.getGrupo())) {
                    if (p.getAnoPub() <= 2020 && p.getAnoPub() >= 2015) {
                        total += 1;
                    }
                }
            }
            System.out.println("\t" + g3.getAcronimo() + ": " + total + " publicacoes");
        }

        //d) Number of publications of the last 5 years, grouped by year, type of publication and impact factor
        System.out.println("d) Numero de publicacoes, dos ultimos 5 anos, agrupadas por ano, tipo de publicacao e fator de impacto:");
        for (Grupos g4 : grupo) {
            System.out.println("* * * * * * * * * * * * * * Grupo "+g4.getAcronimo()+" * * * * * * * * * * * * * *");
            for (int ano4 = 2020; ano4 >= 2015; ano4--) {
                // [Impact A, Impact B, Impact C]
                int[] pubConf = new int[3];
                int[] pubRevista = new int[3];
                int[] pubLivro = new int[3];
                int[] pubLivroCap = new int[3];
                int[] pubLivroConf = new int[3];
                    
                for (Publicacoes p4: publicacao) {
                    if (ano4 == p4.getAnoPub()) {
                        if(g4.getAcronimo().equals(p4.getGrupo())) {
                            if(p4.isArticle() == 1) {    //Conference Article
                                if(p4.calculaFator().equals("A"))   pubConf[0] += 1;
                                if(p4.calculaFator().equals("B"))   pubConf[1] += 1;
                                if(p4.calculaFator().equals("C"))   pubConf[2] += 1;
                            }
                            if(p4.isArticle() == 2) {   //Magazine Article
                                if(p4.calculaFator().equals("A"))   pubRevista[0] += 1;
                                if(p4.calculaFator().equals("B"))   pubRevista[1] += 1;
                                if(p4.calculaFator().equals("C"))   pubRevista[2] += 1;
                            }
                            if(p4.isArticle() == 3) {   //Book Article
                                if(p4.calculaFator().equals("A"))   pubLivro[0] += 1;
                                if(p4.calculaFator().equals("B"))   pubLivro[1] += 1;
                                if(p4.calculaFator().equals("C"))   pubLivro[2] += 1;
                            }
                            if(p4.isArticle() == 4) {   //Book Shapeter Article
                                if(p4.calculaFator().equals("A"))   pubLivroCap[0] += 1;
                                if(p4.calculaFator().equals("B"))   pubLivroCap[1] += 1;
                                if(p4.calculaFator().equals("C"))   pubLivroCap[2] += 1;
                            }
                            if(p4.isArticle() == 5) {   //Conference Book Article
                                if(p4.calculaFator().equals("A"))   pubLivroConf[0] += 1;
                                if(p4.calculaFator().equals("B"))   pubLivroConf[1] += 1;
                                if(p4.calculaFator().equals("C"))   pubLivroConf[2] += 1;
                            }
                        }
                    }
                }
                //Prints all publications of the group
                if (pubConf[0] == 0 && pubConf[1] == 0 && pubConf[2] == 0 && pubRevista[0] == 0 && pubRevista[1] == 0 && pubRevista[2] == 0 
                        && pubLivro[0] == 0 && pubLivro[1] == 0 && pubLivro[2] == 0 && pubLivroCap[0] == 0 && pubLivroCap[1] == 0 
                        && pubLivroCap[2] == 0 && pubLivroConf[0] == 0 && pubLivroConf[1] == 0 && pubLivroConf[2] == 0) {
                } else {
                    System.out.println("* Ano " + ano4 + " *");
                }
                if (pubConf[0] != 0 || pubConf[1] != 0 || pubConf[2] != 0) {
                    System.out.println("  -> Conferencia");
                    imprimirNum(pubConf);
                }
                if (pubRevista[0] != 0 || pubRevista[1] != 0 || pubRevista[2] != 0) {
                    System.out.println("  -> Revista");
                    imprimirNum(pubRevista);
                }
                if (pubLivro[0] != 0 || pubLivro[1] != 0 || pubLivro[2] != 0) {
                    System.out.println("  -> Livro");
                    imprimirNum(pubLivro);
                }
                if (pubLivroCap[0] != 0 || pubLivroCap[1] != 0 || pubLivroCap[2] != 0) {
                    System.out.println("  -> Capitulo Livro");
                    imprimirNum(pubLivroCap);
                }
                if (pubLivroConf[0] != 0 || pubLivroConf[1] != 0 || pubLivroConf[2] != 0) {
                    System.out.println("  -> Livro Artigos Conferencia");
                    imprimirNum(pubLivroConf);
                }
            }           
        }
        System.out.println("");
    }

    /**
     * Checks if the authors is an effective member or a student
     * @param listaAutores - list with authors
     * @return autores - authors
     */
    public String verificaAutores(String[] listaAutores) {
        String autores = "Autores: ";
        for (int j = 0; j < listaAutores.length; j++) {
            for (Investigadores i : investigador) {
                if (i.getNome().equals(listaAutores[j])) {
                    if (i.isInv().equals("M")) {
                        if (!autores.equals("Autores: ")) {
                            autores += ", ";
                        }
                        String[] nome1 = listaAutores[j].split(" ");
                        int comp1 = nome1.length;
                        autores += "Professor " + nome1[0] + " " + nome1[comp1 - 1];
                    }
                    if (i.isInv().equals("E")) {
                        if (!autores.isEmpty()) {
                            autores += ", ";
                        }
                        String[] nome2 = listaAutores[j].split(" ");
                        String[] letras = nome2[0].split("");
                        int comp2 = nome2.length;
                        autores += letras[0] + ". " + nome2[comp2 - 1];
                    }
                }
            }
        }
        return autores;
    }

    /**
     * Adds the authors and the toString of the publication in position 0 if
     * impact factor is A, in position 1 if impact factor is B and in the
     * posicion 2 if impact factor is C
     *
     * @param fator - impact factor
     * @param pub - String[] with the publications
     * @param autores - authors of the publication
     * @param toString - toString of the publication that is added
     * @return publication 
     */
    public String[] adiciona(String fator, String[] pub, String autores, String toString) {
        if (fator.equals("A")) {
            if (pub[0] == null) {
                pub[0] = autores + toString;
            } else {
                pub[0] += "\n\n" + autores + toString;
            }
        }
        if (fator.equals("B")) {
            if (pub[1] == null) {
                pub[1] = autores + toString;
            } else {
                pub[1] += "\n\n" + autores + toString;
            }
        }
        if (fator.equals("C")) {
            if (pub[2] == null) {
                pub[2] = autores + toString;
            } else {
                pub[2] += "\n\n" + autores + toString;
            }
        }
        return pub;
    }

    /**
     * Prints the publications by impact fator
     * @param pub - String with publications
     */
    public void imprimirPub(String[] pub) {
        if (pub[0] != null) {
            System.out.println("--> Impacto A:\n" + pub[0]);
        }
        if (pub[1] != null) {
            System.out.println("--> Impacto B:\n" + pub[1]);
        }
        if (pub[2] != null) {
            System.out.println("--> Impacto C:\n" + pub[2]);
        }
    }
    
    /**
     * Prints the number of publications by impact factor
     * @param pub - String with the number of publications
     */
    public void imprimirNum(int[] pub) {
        if (pub[0] != 0) {
            if (pub[0] != 1) {
                System.out.println("\tImpacto A: " + pub[0] + " publicacoes");
            } else {
                System.out.println("\tImpacto A: " + pub[0] + " publicacao");
            }
        }
        if (pub[1] != 0) {
            if (pub[1] != 1) {
                System.out.println("\tImpacto B: " + pub[1] + " publicacoes");
            } else {
                System.out.println("\tImpacto B: " + pub[1] + " publicacao");
            }
        }
        if (pub[2] != 0) {
            if (pub[2] != 1) {
                System.out.println("\tImpacto C: " + pub[2] + " publicacoes");
            } else {
                System.out.println("\tImpacto C: " + pub[2] + " publicacao");
            }
        }
    }
}
