class Section{
	#name;
	#questions;

	constructor(name, questions){
		this.#name = name;
		this.#questions = questions;
	}

	get name(){
		return this.#name;
	}

	get questions(){
		return this.#questions;
	}

	static async loadFromJSON(jsonFile){
		let result = null;
		let questions = [];
		try{
			result = await fetch("./content/"+jsonFile+".json");
			result = await result.json();
		}catch(e){
			console.log(e);
			return;
		}
		result.Questions.forEach(element => {
			questions.push(new Question(element.Number, element.Date, element.Text));
		});
		return new Section(result.Section, questions);
	}
}

window.Section = Section.prototype;