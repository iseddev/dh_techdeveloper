import { memo } from "react";

const ButtonIncrement = ({ onClick }) => {
	console.log("Child component ButtonIncrement rendered");
	return <button onClick={onClick}>Increment</button>;
};

// We use memo to avoid the re-render of this component through save the reference in memory of the function(onClick) that comes from props. If the reference doesn't change, the component doesn't re-render.
export default memo(ButtonIncrement);
