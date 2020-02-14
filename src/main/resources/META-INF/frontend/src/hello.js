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
                 position: absolute;
            }
         </style>
         <script type="text/javascript">
            oQuickReply.swap('somid');
         </script>
         <iron-scroll-threshold id="scrollTheshold" on-lower-threshold="_load" scroll-target="document">
            <iron-swipeable-container disable-swipe on-iron-swipe="handleSwipe" scroll-target="document">
                <template id="list" is="dom-repeat" items="{{items}}">
                    <div  class="block">
                        <paper-card>
                            <div class="card-content">
                              <div class="cafe-header">{{item.model}}</div>
                              <p>{{item.price}} $</p>
                              <p class="cafe-light">Small plates, salads &amp; sandwiches in an intimate setting with 12 indoor seats plus patio seating.</p>
                            </div>
                            <div class="card-actions">
                                 <p>Tonights availability</p>
                            </div>
                        </paper-card>
                    </div>
                </template>
            </iron-swipeable-container >
         </iron-scroll-threshold>
       `;
     }

      _load (e) {
         var carAmount = this.$server.getCarAmount;
         this.$server.loadMoreData(e.target.getElementsByClassName('block').length);
         setTimeout(() => {
             this.$.scrollTheshold.clearTriggers();
         }, 500);
      }

     handleSwipe(e) {
         var i = this.$.list.indexForElement(e.detail.target)
         var index = this.$.list.items[i].id;
         this.$server.deleteItem(index);
         if (e.target.getElementsByClassName('block').length < 5) {
            this._load(e)
         }
         console.log("After deletion", e.target.getElementsByClassName('block').length)
     }

   }

 customElements.define('hello-world', HelloWorld);