class MultithreadingProcess implements Runnable
{
    public void run()
    {
        try
        {
            ChocolateBoiler boiler = ChocolateBoiler.getInstance();
        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
    }
}

public class ChocolateBoiler {
    private static ChocolateBoiler instance;
    private boolean empty;
    private boolean boiled;

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoiler getInstance() {
        if (instance == null) {
            instance = new ChocolateBoiler();
            System.out.println("Primera instancia creada\n");
        }
        System.out.println("Esta instancia ya existe\n");
        return instance;
    }

    public void fill(){
        if(isEmpty()){
            empty = false;
            boiled = false;
        }
    }

    public void drain(){
        if(isEmpty() && isBoiled()){
            //drain the boiled milk and chocolate
            empty = true;
        }
    }

    public void boil(){
        if(!isEmpty() && isBoiled()){
            //bring the contents to a boil
            boiled = true;
        }
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isBoiled(){
        return boiled;
    }

    public static void main(String[] args) {
        int n_threads = 8;
        for (int i = 0; i < n_threads; i++) {
            Thread object = new Thread(new MultithreadingProcess());
            object.start();
        }
    }
}
