package shop.reav.reavproj.model;

public class Reviews {

  private int review_no;
  private int itemID;
  private String user;
  private String email;
  private String review;
  private int rating;
  private double weight;

  public Reviews(
    int review_no,
    int itemID,
    String user,
    String email,
    String review,
    int rating,
    double weight
  ) {
    this.review_no = review_no;
    this.itemID = itemID;
    this.user = user;
    this.email = email;
    this.review = review;
    this.rating = rating;
    this.weight = weight;
  }

  public int getReview_no() {
    return review_no;
  }

  public void setReview_no(int review_no) {
    this.review_no = review_no;
  }

  public int getItemID() {
    return itemID;
  }

  public void setItemID(int itemID) {
    this.itemID = itemID;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }
}
