package wcci.reviewssite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import wcci.reviewssite.model.Category;
import wcci.reviewssite.model.Review;
import wcci.reviewssite.model.Tag;
import wcci.reviewssite.repos.CategoryCrudRepo;
import wcci.reviewssite.repos.CommentCrudRepo;
import wcci.reviewssite.repos.ReviewCrudRepo;
import wcci.reviewssite.repos.TagCrudRepo;

@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	private ReviewCrudRepo reviewRepo;

	@Autowired
	private CategoryCrudRepo categoryRepo;

	@Autowired
	private CommentCrudRepo commentRepo;

	@Autowired
	private TagCrudRepo tagRepo;

	@Override
	public void run(String... args) throws Exception {

//		Category cat01 = new Category("Comedy");
//		categoryRepo.save(cat01);
//
//		Category cat02 = new Category("Crappy Super Hero Movies");
//		categoryRepo.save(cat02);
//
//		Category cat03 = new Category("Horror");
//		categoryRepo.save(cat03);
//
//		Review stone = new Review("Stone", "Not Null", "Not Null", cat01);
//		reviewRepo.save(stone);
//
//		// doing it this way avoids having the object exist in a unsaved state outside
//		// the repo.
//		Review roses = reviewRepo.save(new Review("Roses", "Not Null", "Not Null", cat02));
//
//		Review rolling = reviewRepo.save(new Review("Rolling", "Not Null", "Not Null", cat02));
//
//		Review guns = reviewRepo.save(new Review("Guns", "Not Null", "Not Null", cat02));
//
//		// doing it this way forces it to goto the Repo and get a ID
//		Tag sticker = tagRepo.save(new Tag("Sticker"));
////		tagRepo.save(sticker); no longer need to do this because of edits on line above
//
//		// trying to get tags to work
//
//		// this where moved about the addReview step
////		roses = reviewRepo.save(roses);
////		guns = reviewRepo.save(guns);
////		rolling = reviewRepo.save(rolling);
//
//		roses.addTag(sticker);
//		guns.addTag(sticker);
//		rolling.addTag(sticker);
////		sticker.addReview(roses);
////		sticker.addReview(guns);
////		sticker.addReview(rolling);
////		tagRepo.save(sticker);
//		reviewRepo.save(roses);
//		reviewRepo.save(guns);
//		reviewRepo.save(rolling);
//
////		roses.addTag(sticker);
////		guns.addTag(sticker);
////		rolling.addTag(sticker);
//
////		for(Review rev : sticker.getReviews()) {
////			System.out.println(rev.getTitle() + " is the TITLE");
////		}
////		
////		for(Tag tag : roses.getTags()) {
////			System.out.println(tag.getName() + " is the TITLE");
////		}
//
////		System.out.println(sticker.getReviews().size() + "LOOK HERE<-----");
////		
////		Review retrievedRoses = reviewRepo.findById(roses.getId()).get();
////		Collection<Tag> tags = retrievedRoses.getTags();
////		System.out.println(tags.size() + "LOOK HERE<-----");
//
//		Tag water = new Tag("Water");
//		tagRepo.save(water);
//
//		Comment sucks = new Comment(stone, "This review was terrible, why would you write this!?");
//		commentRepo.save(sucks);
//
//		Comment exactly = new Comment(stone, "Exactly what I thought, great review!");
//		commentRepo.save(exactly);

		// populateWithContent(5);

		ArrayList<Category> categories = generateCategories();
		for (Category category : categories) {
			categoryRepo.save(category);
		}

		ArrayList<Review> reviews = generateReviews(10);
		for (Review review : reviews) {
			reviewRepo.save(review);
		}

		// assignTagsToReviews(4);

		ArrayList<Tag> tags = generateTags();
		for (Tag tag : tags) {
			tagRepo.save(tag);
		}

		//assignTagsToReviews();
	}

	private void assignTagsToReviews() {
		Random random = new Random(System.nanoTime());
		ArrayList<Tag> tags = new ArrayList<Tag>();
		for (Tag tag : tagRepo.findAll()) {
			tags.add(tag);
		}			
		
		for (Review review : reviewRepo.findAll()) {
			int id = random.nextInt(tags.size());
			Tag tag = tags.get(id);
			System.out.println(tag.getName());
			review.addTag(tagRepo.save(tags.get(id)));
			//reviewRepo.save(review);
		}
	}

	private ArrayList<Review> generateReviews(int reviewsToCreate) {
		ArrayList<Category> castedCategories = new ArrayList<Category>();
		for (Category category : categoryRepo.findAll()) {
			castedCategories.add(category);
		}

		String imgPath = "main/resources/static/images/Placeholder.png";
		Random random = new Random(System.nanoTime());
		ArrayList<Review> reviews = new ArrayList<Review>();

		for (int i = 0; i < reviewsToCreate; i++) {
			Category category = castedCategories.get(random.nextInt(castedCategories.size()));
			Review review = new Review(generateTitle(), imgPath, generateContent(), category);
			reviews.add(review);
		}
		return reviews;
	}

	private String generateTitle() {
//		Random random = new Random(System.nanoTime());
//		String[] chars = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
//				"s", "t", "u", "v", "w", "x", "y", "z" };
//		String title = "";
//		for (int i = 0; i < 15; i++) {
//			title += chars[random.nextInt(chars.length)];
//		}
//		return title;
		return "This is a title.";
	}

	private String generateContent() {
//		Random random = new Random(System.nanoTime());
//		String[] chars = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
//				"s", "t", "u", "v", "w", "x", "y", "z", " ", " ", "\n" };
//		String content = "";
//		for (int i = 0; i < 200 + random.nextInt(800); i++) {
//			content += chars[random.nextInt(chars.length)];
//		}
//		return content;
		return "This is content.";
	}

	private ArrayList<Category> generateCategories() {
		ArrayList<Category> categories = new ArrayList<Category>();
		categories.add(new Category("Absurdist"));
		categories.add(new Category("Action"));
		categories.add(new Category("Adventure"));
		categories.add(new Category("Comedy"));
		categories.add(new Category("Crime"));
		categories.add(new Category("Drama"));
		categories.add(new Category("Fantasy"));
		categories.add(new Category("Historical"));
		categories.add(new Category("Historical fiction"));
		categories.add(new Category("Horror"));
		categories.add(new Category("Magical realism"));
		categories.add(new Category("Mystery"));
		categories.add(new Category("Paranoid Fiction"));
		categories.add(new Category("Philosophical"));
		categories.add(new Category("Political"));
		categories.add(new Category("Romance"));
		categories.add(new Category("Saga"));
		categories.add(new Category("Satire"));
		categories.add(new Category("Science fiction"));
		categories.add(new Category("Social"));
		categories.add(new Category("Speculative"));
		categories.add(new Category("Thriller"));
		return categories;
	}

	private ArrayList<Tag> generateTags() {
		ArrayList<Tag> tags = new ArrayList<Tag>();
		tags.add(new Tag("zombie"));
		tags.add(new Tag("vampire"));
		tags.add(new Tag("werewolf"));
		tags.add(new Tag("magic"));
		tags.add(new Tag("wizards"));
		tags.add(new Tag("scary"));
		tags.add(new Tag("evil"));
		tags.add(new Tag("dark"));
		tags.add(new Tag("night"));
		tags.add(new Tag("blood"));
		tags.add(new Tag("space"));
		tags.add(new Tag("war"));
		tags.add(new Tag("star"));
		tags.add(new Tag("time"));
		tags.add(new Tag("alien"));
		tags.add(new Tag("earth"));
		tags.add(new Tag("planet"));
		tags.add(new Tag("world"));
		tags.add(new Tag("lost"));
		tags.add(new Tag("wild"));
		tags.add(new Tag("black"));
		tags.add(new Tag("funny"));
		tags.add(new Tag("love"));
		tags.add(new Tag("life"));
		tags.add(new Tag("day"));
		tags.add(new Tag("little"));
		tags.add(new Tag("west"));
		tags.add(new Tag("cowboy"));
		tags.add(new Tag("law"));
		tags.add(new Tag("gun"));
		tags.add(new Tag("island"));
		tags.add(new Tag("funny"));
		return tags;
	}

	public static <T> Collection<T> getCollectionFromIteralbe(Iterable<T> itr) {
// Create an empty Collection to hold the result 
		Collection<T> cltn = new ArrayList<T>();

// Iterate through the iterable to 
// add each element into the collection 
		for (T t : itr)
			cltn.add(t);

// Return the converted collection 
		return cltn;
	}
}
