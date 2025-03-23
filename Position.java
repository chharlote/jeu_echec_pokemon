//GERME CHarlotte TPA

public class Position {


    private int x, y;
    private char[] tabLettre = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
    private char[] tabChiffre = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};


    // constructeur par défaut de la position
    // qui met la postion à x=0 et y=0
    public Position(){

        this.x =0 ;
        this.y =0 ;

    }


    // Constructeur par copie qui va copier une
    // Position passee en parametre.
    public Position(Position p){

        this.x = p.x;
        this.y = p.y;

    }


    // Constructeur de Position avec en paramètre les nouvelles valeurs de x et y
    public Position(int x, int y){

        if (x>=0 && x<=8){
            this.x = x;
        }
        else{
            System.out.println("x doit être un chiffre entre 0 à 8.");
        }

        if (y>=0 && y<=8){
            this.y = y;
        }
        else{
            System.out.println("y doit être un chiffre entre 0 à 8.");
        }
    }



    public Position(String id){


        int i;

        for ( i = 0; i < tabLettre.length; i++) {

            if (id.charAt(0) == tabLettre[i]){

                this.x =i;
            }           
        } 

        for ( i = 0; i < tabChiffre.length; i++) {

            if (id.charAt(1) == tabChiffre[i]){

                this.y =i;
            }           
        } 


    }



    // Retourne la valeur de x
    public int getX(){

        return this.x ;
    }


    // Retourne la valeur de y
    public int getY(){

        return this.y;
    }

 


    // met à jour la valeur x grâce à le lettre en paramètre
    public void setX(char lettre){
        int i;

        for ( i = 0; i < tabLettre.length; i++) {

            if (lettre == tabLettre[i]){

                this.x =i;
            }           
        }
         
    }



    // met à jour la valeur y grâce au chiffre en paramètre
    public void setY(char chiffre){

        int i;
        for ( i = 0; i < tabChiffre.length; i++) {

            if (chiffre == tabChiffre[i]){

                this.y =i;
            }           
        } 


    }

    // mets à jour la valeur de x
    public void setX(int x){

        if (x>=0 && x<=8){
            this.x = x;
        }
        else{
            System.out.println("x doit être un chiffre entre 0 à 8.");
        }


    }

    // met à jour le valeur de y
    public void setY(int y){

        if (y>=0 && y<=8){
            this.y = y;
        }
        else{
            System.out.println("y doit être un chiffre entre 0 à 8.");
        }


    }




    public boolean equals(Object obj){

        if (obj == this){
            return true;
        }

        if (!(obj instanceof Position)){
            return false;
        }

        Position p = (Position)obj;

        return(this.x == p.x && this.y ==p.y);
    }


    // méthode toString
    public String toString(){

        return new String(tabLettre[this.getX()]+""+tabChiffre[this.getY()]+"\n");
    }
    
}
