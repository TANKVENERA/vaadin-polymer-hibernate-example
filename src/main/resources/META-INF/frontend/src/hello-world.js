import {PolymerElement,html} from '@polymer/polymer';
import '@polymer/iron-swipeable-container/iron-swipeable-container.js';
import '@polymer/paper-card/paper-card.js';
import '@polymer/iron-scroll-threshold/iron-scroll-threshold.js';

 class HelloWorld extends PolymerElement {
    static get template() {
       return html`
         <style>
           .cafe-header { @apply --paper-font-headline; }
           .cafe-light { color: var(--paper-grey-600); }
           .cafe-location {
                 float: right;
                 font-size: 15px;
                 vertical-align: middle;
           }
            .block:hover {
                 cursor: pointer;
                     }
            .block{
                 padding-bottom: 15px;
            }
            iron-swipeable-container{
                 width: 40%;
                 margin-left: 30%;
                 padding-bottom: 20px;
            }
         </style>
         <iron-scroll-threshold id="scrollTheshold" on-lower-threshold="loadData" scroll-target="document">
                <template id="list" items="{{items}}" is="dom-repeat">
                        <div id="{{item.id}}">
                            <iron-swipeable-container  on-iron-swipe="handleSwipe">
                                <paper-card class="block">
                                    <div class="card-content">
                                      <div class="cafe-header">{{item.model}}</div>
                                      <p>{{item.price}} $</p>
                                      <p class="cafe-light">Small plates, salads &amp; sandwiches in an intimate setting with 12 indoor seats plus patio seating.</p>
                                    </div>
                                    <div class="card-actions">
                                         <p>Tonights availability</p>
                                    </div>
                                </paper-card>
                            </iron-swipeable-container>
                        </div>
                </template>
         </iron-scroll-threshold>
       `;
     }

      loadData (e) {
      console.log('DATA!!!!!')
         setTimeout(() => {
             this.$.scrollTheshold.clearTriggers();
         }, 500);
      }

     handleSwipe(e) {
        e.path[0].style.display = "none";
    }

}

 customElements.define('hello-world', HelloWorld);