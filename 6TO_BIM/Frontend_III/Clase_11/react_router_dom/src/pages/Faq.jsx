import { Link, useParams, useNavigate } from "react-router-dom";

import { faqs } from "../data/faqs";

const Faq = () => {
	const totalFaqs = faqs.length;
	const params = useParams();
	const navigate = useNavigate();

	// We get the object that matches the id from the URL
	const question = faqs.find((faq) => faq.id === parseInt(params.id));

	return (
		<>
			<div>
				<h2>{question?.question}</h2>
				<p>{question?.answer}</p>
			</div>
			<div>
				<Link to="/faqs">Go to FAQs</Link>
				{
					// If the question is the first one, we don't show the "Previous" button
					question.id === 1 ? null : (
						<button onClick={() => navigate(`/faq/${parseInt(question.id) - 1}`)}>Previous</button>
					)
				}
				{
					// If the question is the last one, we don't show the "Next" button
					question.id === totalFaqs ? null : (
						<button onClick={() => navigate(`/faq/${parseInt(question.id) + 1}`)}>Next</button>
					)
				}
			</div>
		</>
	);
};

export default Faq;
