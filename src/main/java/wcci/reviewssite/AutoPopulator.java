package wcci.reviewssite;

import java.util.ArrayList;
import java.util.Random;

import wcci.reviewssite.model.Category;
import wcci.reviewssite.model.Review;
import wcci.reviewssite.model.Tag;
import wcci.reviewssite.repos.CategoryCrudRepo;
import wcci.reviewssite.repos.TagCrudRepo;

public class AutoPopulator {

	public static final String DEFAULT_IMG_URL = "https://assets3.thrillist.com/v1/image/2819572/size/tmg-article_tall;jpeg_quality=20.jpg";
	public static final ArrayList<Category> DEFAULT_CATEGORIES = generateCategories();
	public static final ArrayList<Tag> DEFAULT_TAGS = generateTags();

	private static final Random RANDOM = new Random(System.nanoTime());

	public AutoPopulator()
		{
		}

	public void saveDefaults(CategoryCrudRepo categoryRepo, TagCrudRepo tagRepo)
		{
		for (Category category : DEFAULT_CATEGORIES)
			{
			categoryRepo.save(category);
			}

		for (Tag tag : DEFAULT_TAGS)
			{
			tagRepo.save(tag);
			}
		}

	public void addRandomTagsToReview(Review review, int minNumOfTags, int maxNumOfTags)
		{
		int numOfTags = 0;
		if (minNumOfTags < 0 || maxNumOfTags < minNumOfTags)
			{
			numOfTags = 0;
			}
		else if (maxNumOfTags == minNumOfTags)
			{
			numOfTags = 1;
			}
		else
			{
			numOfTags = minNumOfTags + RANDOM.nextInt(maxNumOfTags - minNumOfTags);
			}

		if (numOfTags == 0)
			{
			return;
			}
		else
			{
			for (int i = 0; i < numOfTags; i++)
				{
				review.addTag(getRandomTag());
				}
			}
		}

	public ArrayList<Review> createDefaultReviews()
		{
		ArrayList<Review> reviews = new ArrayList<Review>();
		String title = generateTitle();
		String imgURL = DEFAULT_IMG_URL;
		String content = generateContent();
		Category category = getRandomCategory();

		title = "Taxi Driver";
		imgURL = "https://i.pinimg.com/originals/23/55/af/2355af0ba1047200f0b6fb2233579a18.jpg";
		content = "Considered by many to be Martin Scorsese’s masterpiece, Taxi Driver takes a look at the tragic life of Travis Bickle, played by Robert De Niro, an ex-marine loner insomniac turned New York cabby. Travis is a ‘walking contradiction, partly truth and partly fiction.’ For instance Travis despises the scum of the streets of New York, yet he only drives in the worst areas. His worldview is a self-fulfilling prophecy because he only exposes himself to the worst he can find. As strange as his behavior is, Travis Bickle is a character many viewers relate to, some even claiming the story was literally plagiarized from their own life. This review wouldn’t be complete without mentioning De Nero’s most famous scene of his career, in which he turns to a mirror and antagonistically asks ‘You talkin’ to me?’ Then, using a slick quickdraw contraption made from a cabinet slide, he whips out a magnum revolver. But even without this iconic scene, Taxi Driver would still be one of the best movies ever filmed.";
		category = DEFAULT_CATEGORIES.get(12); // "Paranoid Fiction"
		reviews.add(new Review(title, imgURL, content, category));

		title = "Citizen Kane";
		imgURL = "https://upload.wikimedia.org/wikipedia/en/thumb/c/ce/Citizenkane.jpg/220px-Citizenkane.jpg";
		content = "Citizen Kane is a 1941 American mystery drama film by Orson Welles, its producer, co-screenwriter, director and star. The picture was Welles's first feature film. Nominated for Academy Awards in nine categories, it won an Academy Award for Best Writing (Original Screenplay) by Herman J. Mankiewicz and Welles. Considered by many critics, filmmakers, and fans to be the greatest film ever made, Citizen Kane was voted as such in five consecutive British Film Institute Sight & Sound polls of critics, and it topped the American Film Institute's 100 Years ... 100 Movies list in 1998, as well as its 2007 update. Citizen Kane is particularly praised for Gregg Toland's cinematography, Robert Wise's editing, its music, and its narrative structure, all of which have been considered innovative and precedent-setting.";
		category = DEFAULT_CATEGORIES.get(5);
		reviews.add(new Review(title, imgURL, content, category));

		title = "The Matrix";
		imgURL = "https://upload.wikimedia.org/wikipedia/en/thumb/c/c1/The_Matrix_Poster.jpg/220px-The_Matrix_Poster.jpg";
		content = "The Matrix is a 1999 science fiction action film[3][4] written and directed by the Wachowskis[a] that stars Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving, and Joe Pantoliano. It depicts a dystopian future in which humanity is unknowingly trapped inside a simulated reality, the Matrix, created by thought-capable machines (artificial beings)[b] to distract humans while using their bodies as an energy source.[5] When computer programmer Thomas Anderson, under the hacker alias \"Neo\", uncovers this truth, he \"is drawn into a rebellion against the machines\"[5] along with other people who have been freed from the Matrix.";
		category = DEFAULT_CATEGORIES.get(2);
		reviews.add(new Review(title, imgURL, content, category));

		title = "Caddyshack";
		imgURL = "https://upload.wikimedia.org/wikipedia/en/thumb/8/84/Caddyshack_poster.jpg/220px-Caddyshack_poster.jpg";
		content = "Caddyshack is a 1980 American comedy film directed by Harold Ramis, written by Brian Doyle-Murray, Ramis, and Douglas Kenney, and starring Chevy Chase, Rodney Dangerfield, Ted Knight, Michael O'Keefe and Bill Murray. Doyle-Murray also has a supporting role.";
		category = DEFAULT_CATEGORIES.get(3);
		reviews.add(new Review(title, imgURL, content, category));

		title = "The Lion King";
		imgURL = "https://i.pinimg.com/originals/61/44/33/6144337b82f0fce79477620de0556105.gif";
		content = "When asked to recall the most memorable Disney Animated feature, what comes to my mind first is the Lion King. Why the lion king and not something like Mulan, Snow White, Pinocchio, or Fantasia? While these others are certainly memorable by name, the simplicity of the Lion King's plotline and its homage to Shakesphere's Hamlet make it unforgettable. In short, Scar (Claudius) kills Mufasa (King Hamlet) father and usurps throne, Simba (Prince Hamlet) escapes and comes back years later to take back the throne. The animation style and music, courtesy of none other than Elton John and Hans Zimmer, are as distinct as any other disney animation. However, one of the film's themes is a little misplaced, as Simba seems to have benefited from running away from his problems, at least until divine intervention led him back to his pride. Will the live action adaptation meet the bar this film has set? We'll just have to wait and see… 8/10";
		category = getRandomCategory();
		reviews.add(new Review(title, imgURL, content, category));

		title = "The Room";
		imgURL = "https://i.pinimg.com/originals/83/b6/b2/83b6b297d9ca1d1a52875719dc8bf6ff.jpg";
		content = "'I did not hit her. It's not true. It's bullshit. I did not hit her! I did not! oh hai mark.' Writer, director, and lead actor Tommy Wiseau is truly a gift to mankind (though maybe not those who worked directly with his frustrating style of directing). The Room is genuinely entertaining to watch, but not in the way films typically are. The silly robotic flow of dialog makes it seem like this movie was written by either AI or aliens. Heck, just the way Tommy speaks both in film and in the wild is enough to make me wonder which planet he came from. Not all of this movie is inadvertently hilarious however, be advised that viewers must also sit through stale re-hashings of the same scenes on repeat, as well as endless stale sex scenes. But if you make it through, you'll be quoting this movie to your friends, who sat through the journey with you, for years to come. -1/10";
		category = getRandomCategory();
		reviews.add(new Review(title, imgURL, content, category));

		title = "Monty Python and the Holy Grail";
		imgURL = "https://i.pinimg.com/564x/f4/63/4c/f4634cbdd971c43ce1eafd2cdbf63565.jpg";
		content = "Grab your coconuts and holy hand grenades because we're taking a look at Monty Python's most memorable medieval masterpiece. King Arthor's misadventurous quest for the holy grail is filled with the most quotable scenes in comedy from start to finish. These aren't just nonsensical silly-sounding lines one after another, as it deconstructs concepts like Christianity, chivalry, logic and film as a medium of entertainment. For instance instead of painting knights as righteous do-gooders helping those in need, Sir Lancelot massacre's a wedding to save a lad he thought was a lady, poking fun at needlessly violent action scenes in cinema. Even the more boring scenes like Castle Anthrax are redeemed by 4th-wall-breaking-self-deprecation. That being said, not all the scenes are equally funny, falling short of a perfect score, albeit one that is almost fully redeemed by shear charm. 9/10";
		category = getRandomCategory();
		reviews.add(new Review(title, imgURL, content, category));

		title = "Dune 1984";
		imgURL = "https://i.pinimg.com/originals/66/db/f4/66dbf4df2179d98fd82cc9d56aecffdf.jpg";
		content = "While others had been attempting to adapt Dune into a movie since, 1971, David Lynch was the first director to complete the project, following the failures of Arthur P Jacobs and Aliandro De Rosci. And for a film that took $40 million to make, the special effects aren't even up to snuff with other films in this period, like George Lucas's Star Wars. That being said, there is a sort of visual thematic charm that David Lynch brings to the desert which lends back some points to the film on that front. Technical demand aside, the difficulty of streamlining the dense character relationships in the book is enough to make this a challenging movie to make, and especially to watch. 5/10 ";
		category = getRandomCategory();
		reviews.add(new Review(title, imgURL, content, category));

		title = "The Shining";
		imgURL = "https://i.pinimg.com/originals/81/31/d8/8131d806b65f87198ba22b407900bb0e.jpg";
		content = "If you've ever felt a little crazy after being cooped up indoors for a little too long, then you might have some insight into the insanity of Jack Torrance in Stanley Kubrick's The Shining. The paranoid delusions and logical disparity from reality in this film make it hard to put this under the horror genre, fitting better as a psychological horror. It's hard to tell how much is actually happening versus how much is the product of Jack's runaway imagination. Host to many iconic scenes, the unexplained river of blood, those creepy twins, 'here's johnny' (a nudge at Johnny Carson's late night show), and more. But a film can't stand on icons alone, and some of the in-between is slow-paced and almost boring. Still, the artistry and feeling of dread Kubrick brought to the screen is enough to make this title a must for any movie nut. 8/10";
		category = getRandomCategory();
		reviews.add(new Review(title, imgURL, content, category));

		return reviews;
		}

	public Tag getRandomTag()
		{
		int index = RANDOM.nextInt(DEFAULT_TAGS.size());
		return DEFAULT_TAGS.get(index);
		}

	public Category getRandomCategory()
		{
		int index = RANDOM.nextInt(DEFAULT_CATEGORIES.size());
		return DEFAULT_CATEGORIES.get(index);
		}

	public Review createTheDefaultReview()
		{
		String title = "Taxi Driver";
		String imgURL = "https://i.pinimg.com/originals/23/55/af/2355af0ba1047200f0b6fb2233579a18.jpg";
		String content = "Considered by many to be Martin Scorsese’s masterpiece, Taxi Driver takes a look at the tragic life of Travis Bickle, played by Robert De Niro, an ex-marine loner insomniac turned New York cabby. Travis is a ‘walking contradiction, partly truth and partly fiction.’ For instance Travis despises the scum of the streets of New York, yet he only drives in the worst areas. His worldview is a self-fulfilling prophecy because he only exposes himself to the worst he can find. As strange as his behavior is, Travis Bickle is a character many viewers relate to, some even claiming the story was literally plagiarized from their own life. This review wouldn’t be complete without mentioning De Nero’s most famous scene of his career, in which he turns to a mirror and antagonistically asks ‘You talkin’ to me?’ Then, using a slick quickdraw contraption made from a cabinet slide, he whips out a magnum revolver. But even without this iconic scene, Taxi Driver would still be one of the best movies ever filmed.";
		Category category = DEFAULT_CATEGORIES.get(12); // "Paranoid Fiction"
		Review review = new Review(title, imgURL, content, category);
		return review;
		}

	public static String generateTitle()
		{
//	Random random = new Random(System.nanoTime());
//	String[] chars = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
//			"s", "t", "u", "v", "w", "x", "y", "z" };
//	String title = "";
//	for (int i = 0; i < 15; i++) {
//		title += chars[random.nextInt(chars.length)];
//	}
//	return title;
		return "This is a title.";
		}

	public static String generateContent()
		{
//	Random random = new Random(System.nanoTime());
//	String[] chars = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
//			"s", "t", "u", "v", "w", "x", "y", "z", " ", " ", "\n" };
//	String content = "";
//	for (int i = 0; i < 200 + random.nextInt(800); i++) {
//		content += chars[random.nextInt(chars.length)];
//	}
//	return content;
		return "This is content.";
		}

	public static String generateComment()
		{
		return "This is a comment.";
		}

	public static ArrayList<Category> generateCategories()
		{
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

	public static ArrayList<Tag> generateTags()
		{
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
}
