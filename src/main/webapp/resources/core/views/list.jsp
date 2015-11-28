<div class="col-md-4"></div>
	
<div class="col-md-4">
     <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">
                    <span class="glyphicon glyphicon-arrow-right"></span>Em qual restaurante você deseja ir hoje?
                </h3>
            </div>
             <form>
	            <div class="panel-body">
	                <ul class="list-group">
	                <div ng-repeat="restaurant in restaurants">
	                 	<li class="list-group-item">
	                         <div class="radio">
	                             <label>
	                                 <input type="radio" name="restaurantId" value="{{restaurant.id}}" ng-model="formData.restaurantId">
	                                 {{restaurant.name}}
	                             </label>
	                         </div>
	                     </li>
	                 </div>
	                </ul>
	            </div>
	            <div class="panel-footer">
	                <button type="button" class="btn btn-primary btn-sm"  ng-click="vote()">
	                    Votar</button>
	                <a href="/result">Ver Resultado</a></div>
            </form>
        </div>
 
</div>