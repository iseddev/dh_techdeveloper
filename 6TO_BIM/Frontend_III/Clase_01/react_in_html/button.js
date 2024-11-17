// This method get us to create elements using React.
const createComponent = React.createElement;

// This is a React component!
const Button = () =>
	createComponent("button", { onClick: () => alert("You clicked!!!") }, "Click here!");

// We select the root div inside our index.html
const rootContainer = document.querySelector("#root_container");

// Here we call createReact() to create the container div that will hold the HTML to be rendered.
const root = ReactDOM.createRoot(rootContainer);

// We render the Button component inside the root container.
root.render(createComponent(Button));
