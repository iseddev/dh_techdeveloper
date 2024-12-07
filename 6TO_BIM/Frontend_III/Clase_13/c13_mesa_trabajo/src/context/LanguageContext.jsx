import { createContext } from "react";

import { languages } from "../languages/languages";

// TIP: Use createContext and start English as the default language
const LanguageContext = createContext(languages.english);

export default LanguageContext;
