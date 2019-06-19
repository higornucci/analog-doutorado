package exercicio_4_3_43;

public interface UF {

    int count();
    int find(int site);
    boolean connected(int site1, int site2);
    void union(int site1, int site2);

}
