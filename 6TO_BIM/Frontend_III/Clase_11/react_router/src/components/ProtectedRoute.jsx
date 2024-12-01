import { Navigate } from "react-router-dom";

const ProtectedRoute = ({ isLogged, children }) => {
	// return isLogged ? children : <h1>Debes iniciar sesión</h1>;
	return isLogged ? children : <Navigate to="/login" />;
};

export default ProtectedRoute;
