let wrapper = document.getElementById("main");
let btn = document.getElementById("reset");
let testBuilder = new TestBuilder();
loadQuestions();

btn.addEventListener("click", (e) => {
	e.preventDefault();
	clear();
	loadQuestions();
});
function clear(){
	wrapper.innerHTML = null;
}
function loadQuestions(){
	let params = new URLSearchParams(window.location.search);
	let q = params.get("q") ? parseInt(params.get("q")) : 0;
	if(q <= 0){
		q = 1;
	}
	testBuilder.setNumberOfQuestion(q).build().then(result => {
		result.questions.forEach(question => {
			var info_container = generateInfo(question);
			var content_container = generateContent(question);
			container = document.createElement("div");
			container.append(info_container);
			container.append(content_container);
			wrapper.append(container);
		});
		MathJax.typeset();
	});
}


function generateInfo(question){
	var info_container = document.createElement("div");
	info_container.append(generateContainer(question.number));
	info_container.append(generateContainer(question.date));
	info_container.className = "info";
	return info_container;
}

function generateContent(question){
	var content = document.createElement("div");
	content.className = "content-container";
	content.innerHTML = question.text;
	return content;
}

function generateContainer(text){
	var container = document.createElement("div");
	container.append(document.createTextNode(text));
	return container;
}