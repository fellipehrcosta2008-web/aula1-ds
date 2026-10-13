public class Pilha {

    static class No {
        char dado;
        No proximo;

        No(char dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    static class MinhaPilha {
        private No topo;

        public boolean vazia() {
            return topo == null;
        }

        public void empilhar(char caractere) {
            No novo = new No(caractere);
            novo.proximo = topo;
            topo = novo;
        }

        public char desempilhar() {
            if (vazia()) {
                throw new RuntimeException("Pilha vazia!");
            }

            char caractere = topo.dado;
            topo = topo.proximo;

            return caractere;
        }
    }

    public static String inverterPalavras(String texto) {
        MinhaPilha pilha = new MinhaPilha();
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caractere = texto.charAt(i);

            if (caractere != ' ') {
                pilha.empilhar(caractere);
            } else {
                while (!pilha.vazia()) {
                    resultado.append(pilha.desempilhar());
                }

                resultado.append(' ');
            }
        }

        while (!pilha.vazia()) {
            resultado.append(pilha.desempilhar());
        }

        return resultado.toString();
    }

    public static void main(String[] args) {

        String texto1 = "UM CIENTISTA DA COMPUTACAO E UM TECNOLOGO EM SISTEMAS PARA INTERNET DEVEM RESOLVER OS PROBLEMAS LOGICAMENTE";

        String texto2 = "ESARF :ATERCES ODALERAHCAB ME AICNEIC AD OACATUPMOC E O OGOLONCET ME SAMETSIS ARAP TENRETNI OD FI ONAIOG SUPMAC SOHNIRROM OAS SO SEROHLEM SOSRUC ED OACATUPMOC OD ODATSE ED .SAIOG";

        System.out.println("EXEMPLO 1:");
        System.out.println(texto1);
        System.out.println();
        System.out.println(inverterPalavras(texto1));

        System.out.println("\n---------------------------------------------\n");

        System.out.println("EXEMPLO 2:");
        System.out.println(texto2);
        System.out.println();
        System.out.println(inverterPalavras(texto2));
    }
}
