package main.java;

public class FoodDictionary {

	public static String findFoodItemFromDictionary(String itemName) {
		if(itemName.contains("chicken")) {
			if(itemName.contains("breast")) {
				return "chicken breast";
			}
			else if(itemName.contains("thigh")) {
				return "chicken thigh";
			}
			else if(itemName.contains("stock")) {
				return "chicken stock";
			}
			if(itemName.contains("broth")) {
				return "chicken broth";
			}
			else return "chicken";
		}
		if(itemName.contains("salmon")) {
			return "salmon";
		}
		if(itemName.contains("lemon")) {
			if(itemName.contains("juice")) {
				return "lemon juice";
			}
			return "lemon";
		}
		if(itemName.contains("salt")) {
			return "salt";
		}
		if(itemName.contains("butter")) {
			if(itemName.contains("unsalted")) {
				return "unsalted butter";
			}
			return "butter";
		}
		if(itemName.contains("oil")) {
			if(itemName.contains("olive")) {
				return "olive oil";
			}
			if(itemName.contains("vegetable")) {
				return "vegetable oil";
			}
			if(itemName.contains("canola")) {
				return "canola oil";
			}
			if(itemName.contains("sunflower")) {
				return "sunflower oil";
			}
			if(itemName.contains("coconut")) {
				return "coconut oil";
			}
			return "oil";
		}
		if(itemName.contains("pepper")) {
			if(itemName.contains("bell")) {
				if(itemName.contains("red")) {
					return "red bell pepper";
				}
				if(itemName.contains("yellow")) {
					return "yellow bell pepper";
				}
				if(itemName.contains("green")) {
					return "green bell pepper";
				}
				return "bell pepper";
			}
			if(itemName.contains("crushed")) {
				if(itemName.contains("red")) {
					return "crushed red pepper";
				}
				return "crushed pepper";
			}
			return "ground black pepper";
		}
		if(itemName.contains("thyme")) {
			return "thyme";
		}
		if(itemName.contains("basil")) {
			return "basil";
		}
		if(itemName.contains("oregano")) {
			return "oregano";
		}
		if(itemName.contains("rosemary")) {
			return "rosemary";
		}
		if(itemName.contains("garlic")) {
			if(itemName.contains("powder")) {
				return "garlic powder";
			}
			return "garlic";
		}
		if(itemName.contains("parsley")) {
			return "parsley";
		}
		if(itemName.contains("tomato")) {
			if(itemName.contains("diced")) {
				return "diced tomato";
			}
			if(itemName.contains("paste")) {
				return "tomato paste";
			}
			if(itemName.contains("sauce")) {
				return "tomato sauce";
			}
			if(itemName.contains("soup")) {
				return "tomato soup";
			}
			return "tomato";
		}
		if(itemName.contains("breadcrumbs")) {
			return "breadcrumbs";
		}
		if(itemName.contains("milk")) {
			if(itemName.contains("whole")) {
				return "whole milk";
			}
			if(itemName.contains("skim")) {
				return "skim milk";
			}
			if(itemName.contains("almond")) {
				return "almond milk";
			}
			if(itemName.contains("chocolate")) {
				return "chocolate milk";
			}
			return "milk";
		}
		if(itemName.contains("flour")) {
			if(itemName.contains("bread")) {
				return "bread flour";
			}
			if(itemName.contains("wheat")) {
				return "wheat flour";
			}
			if(itemName.contains("barley")) {
				return "barley flour";
			}
			if(itemName.contains("tortilla")) {
				return "flour tortillas";
			}
			return "all-purpose flour";
		}
		if(itemName.contains("peas")) {
			if(itemName.contains("frozen")) {
				return "frozen peas";
			}
			if(itemName.contains("snap")) {
				return "snap peas";
			}
			return "peas";
		}
		if(itemName.contains("beans")) {
			if(itemName.contains("pinto")) {
				return "pinto beans";
			}
			if(itemName.contains("black")) {
				return "black beans";
			}
			if(itemName.contains("kidney")) {
				return "kidney beans";
			}
			if(itemName.contains("fried")) {
				return "refried beans";
			}
			return "beans";
		}
		if(itemName.contains("salsa")) {
			if(itemName.contains("verde")) {
				return "salsa verde";
			}
			return "salsa";
		}
		if(itemName.contains("corn")) {
			if(itemName.contains("cob")) {
				return "corn on the cob";
			}
			if(itemName.contains("cream")) {
				return "creamed corn";
			}
			return "corn";
		}
		if(itemName.contains("cheese")) {
			if(itemName.contains("cheddar")) {
				if(itemName.contains("jack")) {
					return "cheddar-jack cheese";
				}
				return "cheddar cheese";
			}
			if(itemName.contains("mozzarella")) {
				return "mozzarella cheese";
			}
			if(itemName.contains("colby")) {
				return "colby-jack cheese";
			}
			if(itemName.contains("montaray")) {
				return "montaray-jack cheese";
			}
			if(itemName.contains("parmesan")) {
				return "parmesan cheese";
			}
			return "cheese";
		}
		if(itemName.contains("rice")) {
			if(itemName.contains("cooked")) {
				return "cooked rice";
			}
			if(itemName.contains("brown")) {
				return "brown rice";
			}
			return "rice";
		}
		if(itemName.contains("cumin")) {
			return "cumin";
		}
		if(itemName.contains("nutmeg")) {
			return "nutmeg";
		}
		if(itemName.contains("wine")) {
			if(itemName.contains("white")) {
				return "white wine";
			}		if(itemName.contains("red")) {
				return "red wine";
			}
			return "wine";
		}
		if(itemName.contains("sugar")) {
			if(itemName.contains("brown")) {
				return "brown sugar";
			}
			return "sugar";
		}
		
		return itemName;
	}

}
