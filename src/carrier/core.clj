(ns carrier.core
  (:use [cheshire.core :only [generate-string]]
        [clojure-mail.core :as mail]))

(defn json-response
  "Returns a JSON response."
  [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (generate-string data)})

(defn inbox [email password]
  (mail/auth! email password)
  (try 
    (let [messages (take 5 (mail/get-inbox))]
      (json-response {:msg (str (first messages))}))
    (catch Exception e
      (format "Exception -> %s" e))))
  

