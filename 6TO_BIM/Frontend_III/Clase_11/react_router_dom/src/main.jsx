import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import App from "./App.jsx";
import Home from "./pages/Home.jsx";
import About from "./pages/About.jsx";
import Faqs from "./pages/Faqs.jsx";
import Faq from "./pages/Faq.jsx";

import "./index.css";

createRoot(document.getElementById("root")).render(
	<StrictMode>
		<BrowserRouter>
			{/* <App /> */}
			<Routes>
				<Route path="/" element={<App />}>
					<Route index path="home" element={<Home />} />
					<Route path="about" element={<About />} />
					<Route path="faqs" element={<Faqs />} />
					<Route path="faq/:id" element={<Faq />} />
				</Route>
			</Routes>
		</BrowserRouter>
	</StrictMode>
);
