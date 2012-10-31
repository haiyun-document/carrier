(ns carrier.core
  (:use [cheshire.core :only [generate-string]]
        [clojure-mail.core :as mail]))

(defn json-response
  "Returns a JSON response."
  [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (generate-string data)})

(defn inbox [email password limit]
  (mail/auth! email password)
  (try
    (println limit)
    (let [slice (Integer/parseInt limit)
          messages (take slice
                     (reverse (mail/get-inbox)))]
      (json-response
         (map #(mail/read-message %)
              messages)))
    
    (catch Exception e
      (format "Exception -> %s" e))))
  

