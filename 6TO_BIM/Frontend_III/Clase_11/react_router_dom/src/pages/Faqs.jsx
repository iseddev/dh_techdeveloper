import { Link } from "react-router-dom";
import { faqs } from "../data/faqs";

const Faqs = () => {
	return (
		<>
			<h1>You are in Faqs</h1>
			<ol>
				{faqs.map((faq) => (
					<Link key={faq.id} to={`/faq/${faq.id}`}>
						<li>
							<h2>{faq.question}</h2>
						</li>
					</Link>
				))}
			</ol>
		</>
	);
};

export default Faqs;
