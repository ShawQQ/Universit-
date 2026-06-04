class Question{
	#number;
	#date;
	#text;

	constructor(number, date, text){
		this.#number = number;
		this.#date = date;
		this.#text = text;
	}

	get number(){
		return this.#number;
	}

	get date(){
		return this.#date;
	}

	get text(){
		return this.#text;
	}
}

window.Question = Question.prototype