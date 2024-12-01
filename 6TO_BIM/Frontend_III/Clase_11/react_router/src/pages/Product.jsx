import { useParams } from "react-router-dom";

const Product = () => {
	const { id } = useParams();

	// With id we can get the product from the backend or from an API

	return <div>Product with id: {id}</div>;
};

export default Product;
