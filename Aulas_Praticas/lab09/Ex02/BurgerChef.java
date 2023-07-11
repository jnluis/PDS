package lab09.Ex02;

public class BurgerChef extends Chef {

    @Override
    public void chef(String request) {
        if (canHandleRequest(request, "burger")){

            String prefix = "Can I please get a ";
            int startIndex = request.indexOf(prefix) + prefix.length();

            System.out.println("BurgerChef: Starting to cook " + request.substring(startIndex, request.length()-1) + ". Out in 19 minutes!");
        }
        else{
            System.out.println("BurgerChef: I can't cook that.");
            super.chef(request);
        }
    }
    
}
