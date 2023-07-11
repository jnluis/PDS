public interface Empresa {
    public boolean add(Product product);

    public Product remove(String code);

    public Product remove(Product product);

    public boolean share(String code, Client client);

    public boolean share(Product product, Client client);

    public boolean giveBack(String code);

    public boolean giveBack(Product product);
}
