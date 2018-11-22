/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dametto.alex;

/**
 *
 * @author alex
 */
public class Div implements IBinary{
    private String exp1 = "", exp2 = "";
    private IOperation arg1 = null, arg2 = null;
    
    /**
     *
     * @param arg1 il numeratore della divisione
     * @param arg2 il denominatore della divisione
     */
    public Div(IOperation arg1, IOperation arg2){
        this.arg1 = arg1;
        this.arg2 = arg2;
    }
    
    /**
     *
     * @param arg1 il numeratore della divisione
     * @param arg2 il denominatore della divisione
     */
    public Div(String arg1, String arg2){
        this.exp1 = arg1;
        this.exp2 = arg2;
    }
    
    /**
     *
     * @return il valore della divisione
     * @throws Exception in caso di argomento non valido
     */
    @Override
    public Num valuta() throws Exception {
        if(arg1 == null)
            this.arg1 = Exp.parseExp(this.exp1);
        if(arg2 == null)
            this.arg2 = Exp.parseExp(this.exp2);
        
        if(arg2.valuta().toDouble() == 0)
            throw new IllegalArgumentException("Il divisore deve essere diverso da 0.");
        return new Num(arg1.valuta().toDouble() / arg2.valuta().toDouble());
    }

    /**
     *
     * @return il valore della divisione
     * @throws Exception in caso di argomento non valido
     */
    @Override
    public Num valutaPassoAPasso() throws Exception {
        if(arg1 == null)
            this.arg1 = Exp.parseExp(this.exp1);
        if(arg2 == null)
            this.arg2 = Exp.parseExp(this.exp2);
        
        Num ris1 = arg1.valutaPassoAPasso();
        Num ris2 = arg2.valutaPassoAPasso();
        
        System.out.println("Calcolo divisione tra " + ris1.toString() + " e " + ris2.toString());
        
        if(ris2.toDouble() == 0)
            throw new IllegalArgumentException("Il divisore deve essere diverso da 0.");
        
        return new Num(ris1.toDouble() / ris2.toDouble());
    }

    
    /**
     *
     * @return la stringa da poter stampare
     */
    @Override
    public String toString() {
        return "(" + arg1.toString() + ")/(" + arg2.toString() + ")";
    }
}
