<div class="span6">
  <h5>Resultado</h5>
  <div ng-repeat="restaurant in restaurants">
	  <strong>{{restaurant.name}}</strong><span class="pull-right">{{restaurant.votes}} Votos</span>
	  <div class="progress progress-info active">
	      <div class="progress-bar" style="width: {{restaurant.votesPercent}}%;"></div>
	  </div>
  </div>
   <p>
    <a href="/" class="pull-right">Voltar para votação</a>
  </p>
</div>