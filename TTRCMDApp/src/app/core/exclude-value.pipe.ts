import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'excludeValue',
})
export class ExcludeValuePipe implements PipeTransform {
  public transform(listofsymptoms, optionToRemove: string) {
    return listofsymptoms.filter(function (option) {
      return option !== optionToRemove;
    });
  }
}
