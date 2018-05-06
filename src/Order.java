public interface Order {
  public void accept(VisitorInterface v);
  public double getTotalAmount();
}
