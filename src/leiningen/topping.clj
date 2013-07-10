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
    (run (<< "service ~{@service*} start")))

  (task stop
    (debug "stopping service" remote)
    (try 
      (run (<< "service ~{@service*} stop"))
      (catch Exception e 
        (warn "Failed to stop service, assuming it wasn't running."))))) 

(defn topping [{:keys [topping] :as project} & [role]]
  (let [{:keys [app env service]} topping]
     (reset! service* service) 
     (execute basic-deploy app (keyword role) :env env)))

