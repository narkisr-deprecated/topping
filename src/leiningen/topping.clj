(ns leiningen.topping
  (:use          
     [clojure.core.strint :only  (<<)]
    [supernal.baseline :only (basic-deploy) ]
    [taoensso.timbre :only (warn debug)]
    [supernal.core :only (ns- execute execute-task run copy env)]))
                 
(def service* (atom nil))
                 
(ns- deploy

  (task start
    (debug "starting service" remote)
    (run (<< "service ~{@service*} stop")))

  (task stop
    (debug "stopping service" remote)
    (run (<< "service ~{@service*} start")))) 

(defn topping [{:keys [topping] :as project} & args]
  (let [{:keys [app env service]} topping]
     (reset! service* service) 
     (execute basic-deploy app :web :env env)))

