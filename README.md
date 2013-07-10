# Intro

A lein plugin to deploy code into remote machines based upon the [supernal](https://github.com/celestial-ops/supernal) project.

# Usage

Add to your project.clj plugins section:

```clojure
  [topping "0.0.1"]
```

The plugin takes as a parameter the role that will be deployed:

```bash 
 $ lein topping web
```

Now configure it:

```clojure 
 
:topping {
   :service "celestial" 
   :app {:app-name "celestial" :src "target/celestial-0.1.4.jar"}
   :env {:roles {:web #{{:host "192.168.5.6" :user "vagrant" :sudo true}}}}
}

```

Field    | Description
---------|-------------
service  | The service that will be restarted after each deployment.
app-name | Application name the denotes deployment path (/u/apps/app-name).
src      | The deployed artifact (usually a jar file).
roles    | Mapping between roles and hosts.

# Copyright and license

Copyright [2013] [Ronen Narkis]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  [http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
