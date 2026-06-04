class Test{
	#questions;

	constructor(questions){
		this.#questions = questions;
	}

	get questions(){
		return this.#questions;
	}
}

class TestBuilder{
	#sections = [
		//"turing", rimosso dall'esame? 
		"grammar", 
		"computability", 
		"proof", 
		"while"
	];
	#numberOfQuestion;
	#used = {
		"grammar": [],
		"computability": [],
		"proof": [],
		"while": []
	};
	#maxUsed = 10;

	setNumberOfQuestion(numberOfQuestion){
		this.#numberOfQuestion = numberOfQuestion;
		return this;
	}

	async build(){
		let questions = [];
		for(let section of this.#sections){
			section = await Section.loadFromJSON(section);
			for(let i = 0; i < this.#numberOfQuestion; i++){
				let questionNumber = this.#getValidQuestionNumber(section);
				questions.push(section.questions[questionNumber]);
			}
		}

		if(this.#used["grammar"].length > this.#maxUsed){
			this.#resetQuestion();	
		}
		return new Test(questions);
	}
	
	#randomQuestionIndex(length){
		return Math.floor(Math.random() * length);
	}

	#getValidQuestionNumber(section){
		let questionNumber;
		let qUsed = this.#used[section.name];
		do{
			questionNumber = this.#randomQuestionIndex(section.questions.length);
		}while(qUsed.includes(questionNumber));
		qUsed.push(questionNumber);
		return questionNumber;
	}

	#resetQuestion(){
		Object.keys(this.#used).map(key => {
			this.#used[key] = [];
		});
	}
}

window.Test = Test.prototype;
window.TestBuilder = TestBuilder.prototype;