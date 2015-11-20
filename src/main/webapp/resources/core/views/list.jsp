<div class="col-md-4"></div>
	
<div class="col-md-4">
     <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">
                    <span class="glyphicon glyphicon-arrow-right"></span>Em qual restaurante você deseja ir hoje?
                </h3>
            </div>
            <div class="panel-body">
                <ul class="list-group">
                <div ng-repeat="restaurant in restaurants">
                 	<li class="list-group-item">
                         <div class="radio">
                             <label>
                                 <input type="radio" name="optionsRadios">
                                 {{restaurant.name}}
                             </label>
                         </div>
                     </li>
                 </div>
                </ul>
            </div>
            <div class="panel-footer">
                <button type="button" class="btn btn-primary btn-sm">
                    Vote</button>
                <a href="#">View Result</a></div>
        </div>
</div>