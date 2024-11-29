import { useEffect } from "react";

const Message = () => {
	const onMouseMove = ({ screenX, screenY }) => console.log(`X: ${screenX} Y: ${screenY}`);

	useEffect(() => {
		// Console message when the component is mounted the first time
		console.log("Montaje del componente Message");

		// Event listener for mousemove that will be executed when the component is mounted
		window.addEventListener("mousemove", onMouseMove);

		// Return a function to do something when the component is unmounted
		return () => {
			console.log("Se desmontó el componente Message");

			// Remove the event listener when the component is unmounted
			window.removeEventListener("mousemove", onMouseMove);
			console.log("Evento mousemove eliminado ya que el componente Message fue desmontado");
		};
	}, []);

	return <p>Usuario ya existe. Este es un componente condicional/temporal</p>;
};
export default Message;
