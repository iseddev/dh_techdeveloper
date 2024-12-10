import { Link } from "react-router-dom";
import Layout from "../../components/layout/Layout";

import styles from "./Home.module.css";

const Home = () => {
	return (
		<Layout mainTitle="Proyecto Integrador Final">
			<div className={styles.homeHeader}>
				<h2 className={styles.homeHeader__subtitle}>Frontend III - React</h2>
			</div>
			<div className={styles.homeContent}>
				<p>
					En este trabajo integrador final, se desarrolló una aplicación web que permite visualizar
					información sobre personajes de la serie de televisión <b>Dragon Ball</b> . Para ello, se
					utilizó la API pública{" "}
					<Link to={"https://web.dragonball-api.com/"} target="_blank">
						<i>Dragon Ball API</i>
					</Link>
					.
				</p>
				<div className={styles.homeContent__details}>
					<h3>Los requerimientos solicitados son los siguientes:</h3>
					<ol>
						<li>
							Uso de los hooks vistos: <code>useState</code>, <code>useEffect</code>,{" "}
							<code>useContext</code>. OPCIONALES: <code>useCallback</code>, <code>useMemo</code>.
						</li>
						<li>Uso de componentes: Gestión de props de forma correcta</li>
						<li>Uso de CSS mediante module(módulos)</li>
						<li>
							Uso de React Router: Rutas normales(/, /contact, /product, etc.) y rutas
							dinámicas(/character/char1)
						</li>
						<li>Uso de context, uso de Estado Global: Carrito de compras o Favoritos</li>
						<li>Mínimo 3 rutas y 1 tiene que ser dinámica</li>
						<li>OPCIONAL: Formulario de Contacto</li>
						<li>OPCIONAL: Testing</li>
					</ol>
				</div>
			</div>
		</Layout>
	);
};

export default Home;
