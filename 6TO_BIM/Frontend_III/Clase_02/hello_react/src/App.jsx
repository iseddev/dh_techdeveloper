import reactLogo from "./assets/react.svg";
import "./App.css";

function App() {
	return (
		<>
			<div className="App">
				<div>
					<a href="https://vite.dev" target="_blank">
						<img src="/vite.svg" className="logo" alt="Vite logo" />
					</a>
					<a href="https://react.dev" target="_blank">
						<img src={reactLogo} className="logo react" alt="React logo" />
					</a>
				</div>
				<h1>Hello React!!!</h1>
				<div className="card">
					<h2>Aquí comienza nuestra aventura con ReactJS 💪</h2>
				</div>
			</div>
		</>
	);
}

export default App;
